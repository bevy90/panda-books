/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
package panda.books.data;

import java.util.*;
import java.sql.*;

import panda.books.business.Book;

public class BookIO {
    
    public static Book getBookById(Connection con, int id) throws SQLException {
        String preparedSql = "SELECT * FROM Book WHERE book_id = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setInt(1, id);
        ResultSet book = ps.executeQuery();
        boolean bookExist = book.next();
        if (bookExist) {
            return new Book(book.getInt("book_id"), book.getString("title"), book.getString("synapsis"),
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
            books.add(new Book(book.getInt("book_id"), book.getString("title"), book.getString("synapsis"),
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
            books.add(new Book(book.getInt("book_id"), book.getString("title"), book.getString("synapsis"),
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
            books.add(new Book(book.getInt("book_id"), book.getString("title"), book.getString("synapsis"),
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
            books.add(new Book(book.getInt("book_id"), book.getString("title"), book.getString("synapsis"),
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
            books.add(new Book(book.getInt("book_id"), book.getString("title"), book.getString("synapsis"),
                            book.getString("author"), book.getString("genre"), book.getString("location"), book.getDouble("price")));
        }
        return books;
    }
    
    public static int add(Connection con, Book book) throws SQLException {
        String preparedSql = "INSERT INTO Book (title, author, genre, price, synapsis) VALUES (?, ?, ?, ?, ?)";
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
        String preparedSql = "UPDATE Book SET " + column + " = ? WHERE book_id = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setString(1, newValue);
        ps.setInt(2, bookId);
        return ps.executeUpdate();
    }
    
    public static int delete(Connection con, int bookId) throws SQLException {
        String preparedSql = "DELETE FROM Book WHERE book_id = ?";
        PreparedStatement ps = con.prepareStatement(preparedSql);
        ps.setInt(1, bookId);
        return ps.executeUpdate();
    }
}
