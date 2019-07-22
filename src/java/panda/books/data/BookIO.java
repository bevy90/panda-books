package panda.books.data;

import java.util.*;
import java.sql.*;

import panda.books.business.Book;
/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class BookIO {
    public static  Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbUrl = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9299108";
            String username = "sql9299108";
            String password = "YNBsXhqXaq";
//            String dbUrl = "jdbc:mysql://localhost:3306/panda_books";
//            String username = "bev";
//            String password = "WebDevJavaProject";
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            for (Throwable t : e) {
                System.out.println(t);
            }
        }
        return connection;
    }
    
    public static void closeConnection(Connection con) throws SQLException, ClassNotFoundException {
        con.close();
    }
    
    public static Book getBookById(Connection con, int id) throws SQLException {
        String preparedSql = "SELECT * FROM Book WHERE bookId = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setInt(1, id);
        ResultSet book = ps.executeQuery();
        boolean bookExist = book.next();
        if (bookExist) {
            return new Book(book.getInt("bookId"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price"));
        } else {
            return null;
        }
    }
    
    public static ArrayList<Book> getBooksByTitle(Connection con, String title) throws SQLException {
        String preparedSql = "SELECT * FROM Book WHERE title = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, title);
        ResultSet book = ps.executeQuery();
        ArrayList<Book> books = new ArrayList();
        while (book.next()) {
            books.add(new Book(book.getInt("bookId"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price")));
        }
        return books;
    }
    
    public static ArrayList<Book> getBooksByAuthor(Connection con, String author) throws SQLException {
        String preparedSql = "SELECT * FROM Book WHERE author = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, author);
        ResultSet book = ps.executeQuery();
        ArrayList<Book> books = new ArrayList();
        while (book.next()) {
            books.add(new Book(book.getInt("bookId"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price")));
        }
        return books;
    }
    
    public static ArrayList<Book> getBooksByGenre(Connection con, String genre) throws SQLException {
        String preparedSql = "SELECT * FROM Book WHERE genre = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, genre);
        ResultSet book = ps.executeQuery();
        ArrayList<Book> books = new ArrayList();
        while (book.next()) {
            books.add(new Book(book.getInt("bookId"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price")));
        }
        return books;
    }
    
    public static ArrayList<Book> getBooksByPrice(Connection con, Double price) throws SQLException {
        String preparedSql = "SELECT * FROM Book WHERE price = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setDouble(1, price);
        ResultSet book = ps.executeQuery();
        ArrayList<Book> books = new ArrayList();
        while (book.next()) {
            books.add(new Book(book.getInt("bookId"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price")));
        }
        return books;
    }
    
    public static ArrayList<Book> getAll(Connection con) throws SQLException {
        String preparedSql = "SELECT * FROM Book";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ResultSet book = ps.executeQuery();
        ArrayList<Book> books = new ArrayList();
        while (book.next()) {
            books.add(new Book(book.getInt("bookId"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price")));
        }
        return books;
    }
    
    public static int add(Connection con, Book book) throws SQLException {
        String preparedSql = "INSERT INTO User (title, author, genre, price, synapsis) VALUES (?, ?, ?, ?, ?)";
        String title = book.getTitle();
        String author = book.getAuthor();
        String genre = book.getGenre();
        double price = book.getPrice();
        String description = book.getDescription();
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setString(3, genre);
        ps.setDouble(4, price);
        ps.setString(5, description);
        return ps.executeUpdate();
    }
    
    public static int update(Connection con, String column, String newValue, int bookId) throws SQLException {
        String preparedSql = "UPDATE Book SET " + column + " = ? WHERE bookId = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, newValue);
        ps.setInt(2, bookId);
        return ps.executeUpdate();
    }
    
    public static int delete(Connection con, int bookId) throws SQLException {
        String preparedSql = "DELETE FROM Book WHERE bookId = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setInt(1, bookId);
        return ps.executeUpdate();
    }
}
