/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
package panda.books.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import panda.books.business.Book;

import panda.books.business.Order;

public class OrderIO {
    public static Map<Integer, Order> getOrders(Connection con, String email) throws SQLException {
        String preparedSql = "Select order_id, book_id, order_date, status, status_date, quantity From Purchase WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ResultSet book = ps.executeQuery();
        Map<Integer, Order> orders = new HashMap();
        while(book.next()) {
            int id = book.getInt("order_id");
            Book b = BookIO.getBookById(con, book.getInt("book_id"));
            int q = book.getInt("quantity");
            if(orders.containsKey(id)) {
                orders.get(id).addItem(b, q);
                orders.get(id).computeTotalCharges();
            } else {
                Order order = new Order(id);
                order.addItem(b, q);
                order.setOrderDate((Date) book.getDate("order_date"));
                order.setStatusDate((Date) book.getDate("status_date"));
                order.setOrderStatus(book.getString("status"));
                order.computeTotalCharges();
                orders.put(id, order);
            }
        }
        
        return orders;
    }
    
    public static ArrayList<Order> getCurrentOrders(Connection con, String email) throws SQLException {
        String preparedSql = "Select order_id, book_id, order_date, status, status_date, quantity From Purchase WHERE email = ? AND status != ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ps.setString(2, "Delivered");
        ResultSet book = ps.executeQuery();
        Order order = new Order();
        ArrayList<Order> orders = new ArrayList();
        while(book.next()) {
            order.addItem(BookIO.getBookById(con, book.getInt("book_id")), book.getInt("quantity"));
            order.setOrderDate((Date) book.getDate("order_date"));
            order.setStatusDate((Date) book.getDate("status_date"));
            order.setOrderStatus(book.getString("status"));
            order.computeTotalCharges();
            orders.add(order);
        }
        return orders;
    }
    
    public static ArrayList<Order> getPastOrders(Connection con, String email) throws SQLException {
        String preparedSql = "Select order_id, book_id, order_date, status, status_date, quantity From Purchase WHERE email = ? AND status = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ps.setString(2, "Delivered");
        ResultSet book = ps.executeQuery();
        Order order = new Order();
        ArrayList<Order> orders = new ArrayList();
        while(book.next()) {
            order.addItem(BookIO.getBookById(con, book.getInt("book_id")), book.getInt("quantity"));
            order.setOrderDate((Date) book.getDate("order_date"));
            order.setStatusDate((Date) book.getDate("status_date"));
            order.setOrderStatus(book.getString("status"));
            order.computeTotalCharges();
            orders.add(order);
        }
        return orders;
    }
    
    public static int addItem(Connection con, String email, int bookId, int quantity, Date orderDate) throws SQLException {
        String preparedSql = "INSERT INTO Purchase (email, book_id, quantity, order_date, status, status_date) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ps.setInt(2, bookId);
        ps.setInt(3, quantity);
        ps.setDate(4, orderDate);
        ps.setString(5, "Submitted");
        ps.setDate(6, (java.sql.Date) orderDate);
        return ps.executeUpdate();
    }
    
    public static int updateStatus(Connection con, int orderId, String status) throws SQLException {
        String preparedSql = "UPDATE Purchase SET status = ? WHERE order_id = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, status);
        ps.setInt(2, orderId);
        return ps.executeUpdate();
     }
}
