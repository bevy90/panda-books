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
import java.util.Map;

import panda.books.business.Book;
import panda.books.business.Cart;

public class CartIO {
    public static Cart getCart(Connection con, String email) throws SQLException {
        String preparedSql = "Select book_id, quantity From Cart WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ResultSet book = ps.executeQuery();
        Cart cart = new Cart();
        while(book.next()) {
            cart.addItem(BookIO.getBookById(con, book.getInt("book_id")), book.getInt("quantity"));
        }
        cart.computeTotalCharges();
        return cart;
    }
    
    public static int addItem(Connection con, String email, int bookId, int quantity) throws SQLException {
        String preparedSql = "INSERT INTO Cart (email, book_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ps.setInt(2, bookId);
        ps.setInt(3, quantity);
        return ps.executeUpdate();
    }
    
    
     public static int saveCart(Connection con, String email, Cart cart) throws SQLException {
        int count = 0;
        if (cart != null) {
            String preparedSql = "INSERT INTO Cart (email, book_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(preparedSql);
            ps.setString(1, email);
            Cart temp = getCart(con, email);
            for (Map.Entry b : cart.getItems().entrySet()) {
                Book book = (Book) b.getKey();
                int quantity = (int) b.getValue();
                // If the book is already in the cart, update the quantity
                if (temp.getItems().containsKey(book)) {
                    quantity += temp.getItems().get(book);
                    count += updateItem(con, email, book.getBookId(), quantity);
                    continue;
                }
                ps.setInt(2, book.getBookId());
                ps.setInt(3, quantity);
                count += ps.executeUpdate();
            }
        }
        return count;
    }
     
     public static int updateItem(Connection con, String email, int bookId, int quantity) throws SQLException {
        String preparedSql = "UPDATE Cart SET quantity = ? WHERE email = ? AND book_id = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setInt(1, quantity);
        ps.setString(2, email);
        ps.setInt(3, bookId);
        return ps.executeUpdate();
     }
     
     public static int deleteItem(Connection con, String email, int bookId) throws SQLException {
        String preparedSql = "DELETE From Cart WHERE email = ? AND book_id = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ps.setInt(2, bookId);
        return ps.executeUpdate();
     }
}
