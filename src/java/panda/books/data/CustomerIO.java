package panda.books.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import panda.books.business.Book;

import panda.books.business.Customer;
/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class CustomerIO {
    public static Customer getCustomerByEmail(Connection con, String email) throws SQLException {
        String preparedSql = "SELECT * FROM Customer WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ResultSet customer = ps.executeQuery();
        boolean customerExist = customer.next();
        if (customerExist) {
            Customer cust = new Customer(customer.getString("fName"), customer.getString("lName"), customer.getString("email"), 
                    customer.getString("password"), customer.getString("username"));
            for(String temp : customer.getString("favorites").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("wish_list").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("recent").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            return cust;
        } else {
            return null;
        }
    }
    
    public static Customer getCustomerByUsername(Connection con, String username) throws SQLException {
        String preparedSql = "SELECT * FROM Customer WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, username);
        ResultSet customer = ps.executeQuery();
        boolean customerExist = customer.next();
        if (customerExist) {
            Customer cust = new Customer(customer.getString("fName"), customer.getString("lName"), customer.getString("email"), 
                    customer.getString("password"), customer.getString("username"));
            for(String temp : customer.getString("favorites").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("wish_list").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("recent").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            return cust;
        } else {
            return null;
        }
    }
    
    public static ArrayList<Customer> getCustomersByFirstName(Connection con, String fName) throws SQLException {
        String preparedSql = "SELECT * FROM Customer WHERE fName = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, fName);
        ResultSet customer = ps.executeQuery();
        ArrayList<Customer> customers = new ArrayList();
        while (customer.next()) {
            Customer cust = new Customer(customer.getString("fName"), customer.getString("lName"), customer.getString("email"), 
                    customer.getString("password"), customer.getString("username"));
            for(String temp : customer.getString("favorites").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("wish_list").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("recent").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            customers.add(cust);
        }
        return customers;
    }
    
     public static ArrayList<Customer> getCustomersByLastName(Connection con, String lName) throws SQLException {
        String preparedSql = "SELECT * FROM Customer WHERE lName = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, lName);
        ResultSet customer = ps.executeQuery();
        ArrayList<Customer> customers = new ArrayList();
        while (customer.next()) {
            Customer cust = new Customer(customer.getString("fName"), customer.getString("lName"), customer.getString("email"), 
                    customer.getString("password"), customer.getString("username"));
            for(String temp : customer.getString("favorites").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("wish_list").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("recent").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            customers.add(cust);
        }
        return customers;
    }
     
    public static ArrayList<Customer> getAll(Connection con) throws SQLException {
        String preparedSql = "SELECT * FROM Customer";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ResultSet customer = ps.executeQuery();
        ArrayList<Customer> customers = new ArrayList();
        while (customer.next()) {
            Customer cust = new Customer(customer.getString("fName"), customer.getString("lName"), customer.getString("email"), 
                    customer.getString("password"), customer.getString("username"));
            for(String temp : customer.getString("favorites").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            for(String temp : customer.getString("wish_list").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
                
            for(String temp : customer.getString("recent").split(",")) {
                if (!"".equals(temp)) {
                    int id = Integer.parseInt(temp);
                    Book book = BookIO.getBookById(con, id);
                    cust.addToWishList(book);
                }
            }
            customers.add(cust);
        }
        return customers;
    }
    
    public static int add(Connection con, Customer customer) throws SQLException {
        String preparedSql = "INSERT INTO Customer (fName, lName, username, email, password) VALUES (?, ?, ?, ?, ?)";
        String fName = customer.getFirstName();
        String lName = customer.getLastName();
        String email = customer.getEmail();
        String username = customer.getUserName();
        String password = customer.getPassword();
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, fName);
        ps.setString(2, lName);
        ps.setString(4, email);
        ps.setString(3, username);
        ps.setString(5, password);
        return ps.executeUpdate();
    }
    
    public static int update(Connection con, String column, String newValue, String email) throws SQLException {
        String preparedSql = "UPDATE Customer SET " + column + " = ? WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, newValue);
        ps.setString(2, email);
        return ps.executeUpdate();
    }
    
    public static int addFavorite(Connection con, String newValue, String email) throws SQLException {
        String preparedSql = "UPDATE Customer SET favorites = ? WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        String temp = getFavoriteBooks(con, email);
        temp += "," + newValue;
        ps.setString(1, temp);
        ps.setString(2, email);
        return ps.executeUpdate();
    }
    
    public static int removeFavorite(Connection con, String toRemove, String email) throws SQLException {
        String preparedSql = "UPDATE Customer SET favorites = ? WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        String temp = getFavoriteBooks(con, email);
        temp = temp.replace(toRemove, "");
        ps.setString(1, temp);
        ps.setString(2, email);
        return ps.executeUpdate();
    }
    
     public static int addToWishList(Connection con, String newValue, String email) throws SQLException {
        String preparedSql = "UPDATE Customer SET wish_list = ? WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        String temp = getWishList(con, email);
        temp += "," + newValue;
        ps.setString(1, temp);
        ps.setString(2, email);
        return ps.executeUpdate();
    }
    
    public static int removeFromWishList(Connection con, String toRemove, String email) throws SQLException {
        String preparedSql = "UPDATE Customer SET wish_list = ? WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        String temp = getWishList(con, email);
        temp = temp.replace(toRemove, "");
        ps.setString(1, temp);
        ps.setString(2, email);
        return ps.executeUpdate();
    }
    
    public static int delete(Connection con, String email) throws SQLException {
        String preparedSql = "DELETE FROM Customer WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        return ps.executeUpdate();
    }
    
    public static boolean emailExist(Connection con, String email) throws SQLException {
        Customer cust= getCustomerByEmail(con, email);
        return cust != null;
    }
    
    public static String getFavoriteBooks(Connection con, String email) throws SQLException {
        String preparedSql = "SELECT favorites FROM Customer WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ResultSet customer = ps.executeQuery();
        boolean customerExist = customer.next();
        if (customerExist) {
            return customer.getString("favorites");
        }
        return "";
    }
    
    public static String getWishList(Connection con, String email) throws SQLException {
        String preparedSql = "SELECT wish_list FROM Customer WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ResultSet customer = ps.executeQuery();
        boolean customerExist = customer.next();
        if (customerExist) {
            return customer.getString("wish_list");
        }
        return "";
    }
    
    public static int addRecent(Connection con, String newValue, String email) throws SQLException {
        String preparedSql = "UPDATE Customer SET recent = ? WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        String temp = getRecent(con, email);
        temp += "," + newValue;
        ps.setString(1, temp);
        ps.setString(2, email);
        return ps.executeUpdate();
    }
    
    public static String getRecent(Connection con, String email) throws SQLException {
        String preparedSql = "SELECT recent FROM Customer WHERE email = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, email);
        ResultSet customer = ps.executeQuery();
        boolean customerExist = customer.next();
        if (customerExist) {
            return customer.getString("recent");
        }
        return "";
    }
}
