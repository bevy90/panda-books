package panda.books.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import panda.books.business.Book;
import panda.books.business.Cart;
import panda.books.business.Customer;
import panda.books.data.BookIO;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class RequestHandler {
    // Cart management
    public static void modifyCart(HttpServletRequest request, Connection con) throws SQLException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String qty = request.getParameter("quantity");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        // Get the quantity. if it is negative or invalid,
        //it is automatically reset to 1.
        int quantity;
        try {
            quantity = Integer.parseInt(qty);
            if (quantity < 0) {
                quantity = 1;
            }
        } catch (NumberFormatException nfe) {
            quantity = 1;
        }
        
        // Will change to get the product from the database
        Book book = BookIO.getBookById(con, bookId);
        
        
        if (quantity > 0) {
            cart.addItem(book, quantity);
        } else if (quantity == 0) {
            cart.removeItem(book);
        }
        
        cart.computeTotalCharges();
        session.setAttribute("cart", cart);
    }
    
    public static void addToCart(HttpServletRequest request, Connection con) throws SQLException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        
        // Will change to get the product from the database
        Book book = BookIO.getBookById(con, bookId);
        
        for (Map.Entry b : cart.getItems().entrySet()) {
            if (((Book) b.getKey()).getBookId() == bookId) {
                int temp = (int) b.getValue();
                cart.addItem(book, temp+1);
                cart.computeTotalCharges();
                session.setAttribute("cart", cart);
                return;
            }
        }
        
        cart.addItem(book, 1);
        cart.computeTotalCharges();
        session.setAttribute("cart", cart);
    }
    
    // Account management
    public static void createAccount(HttpServletRequest request) {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String homeAddress = request.getParameter("homeAddress");
        
        Customer customer = new Customer(fName, lName, homeAddress, email, password, userName);
        
        // Save information in database
        
        
        // Create cookie
        
        HttpSession session = request.getSession();
        session.setAttribute("customer", customer);
    }
    
    public static boolean login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        // Look for username (can be the user's email) and password combination in database
        
        // if found, create Customer object, set as session attribute then return true
        
        
        // Create Cart object and set as session attribute
        
        // else, return false
        return false;
    }
    
    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        session.removeAttribute("customer");
    }
    
    // Books

    /**
     *
     * @param con
     * @param request
     * @param column
     * @param value
     * @throws SQLException
     */
    public static void getBooks(Connection con, HttpServletRequest request, String column, String value) throws SQLException {
        HttpSession session = request.getSession();
        ArrayList<Book> books;
        if (column.equalsIgnoreCase("title")) {
            books = BookIO.getBooksByTitle(con, value);
        } else if (column.equalsIgnoreCase("genre")) {
            books = BookIO.getBooksByGenre(con, value);
        } else if (column.equalsIgnoreCase("author")) {
            books = BookIO.getBooksByAuthor(con, value);
        } else {
            books = BookIO.getAll(con);
        }
        System.out.println(books);
        session.setAttribute("books", books);
    }
    
    /**
     *
     * @param con
     * @param request
     * @param price
     * @throws SQLException
     */
    public static void getBooksByPrice(Connection con, HttpServletRequest request, double price) throws SQLException {
        HttpSession session = request.getSession();
        ArrayList<Book> books = BookIO.getBooksByPrice(con, price);
        
        session.setAttribute("books", books);
    }
    
    public static void getBookById(Connection con, HttpServletRequest request) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        Book book = BookIO.getBookById(con, id);
        
        session.setAttribute("book", book);
    }
}
