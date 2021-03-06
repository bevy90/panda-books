/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */

package panda.books.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import panda.books.business.*;
import panda.books.data.*;
import panda.books.util.MailUtil;

public class RequestHandler {
    // Cart management
    public static void modifyCart(HttpServletRequest request, Connection con) throws SQLException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String qty = request.getParameter("quantity");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Customer customer = (Customer) session.getAttribute("customer");
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
        
        // get the book from the database
        Book book = BookIO.getBookById(con, bookId);
        
        
        if (quantity > 0) {
            cart.addItem(book, quantity);
            if (customer != null) {
                CartIO.updateItem(con, customer.getEmail(), bookId, quantity);
            }
        } else if (quantity == 0) {
            cart.removeItem(book);
            if (customer != null) {
                CartIO.deleteItem(con, customer.getEmail(), bookId);
            }
        }
        
        cart.computeTotalCharges();
        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cart.getCartSize());
    }
    
    public static void addToCart(HttpServletRequest request, Connection con) throws SQLException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Customer customer = (Customer) session.getAttribute("customer"); 
        if (cart == null) {
            cart = new Cart();
        }
        
        // get the book from the database
        Book book = BookIO.getBookById(con, bookId);
        
        for (Map.Entry b : cart.getItems().entrySet()) {
            if (((Book) b.getKey()).getBookId() == bookId) {
                int temp = (int) b.getValue();
                cart.addItem(book, temp+1);
                if(customer != null) {
                    CartIO.updateItem(con, customer.getEmail(), bookId, temp+1);
                }
                cart.computeTotalCharges();
                session.setAttribute("cart", cart);
                session.setAttribute("cartSize", cart.getCartSize());
                return;
            }
        }
        
        cart.addItem(book, 1);
        if (customer != null) {
            CartIO.addItem(con, customer.getEmail(), bookId, 1);
        }
        cart.computeTotalCharges();
        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cart.getCartSize());
    }
    
    public static void processOrder(HttpServletRequest request, Connection con) throws SQLException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Customer customer = (Customer) session.getAttribute("customer");
        long millis = System.currentTimeMillis(); 
        Date date = new Date(millis);
        Order order = new Order(date);
        
        // Add the items to an order
        order.setItems(cart.getItems());
        order.setTotalCost(cart.getTotal());
        customer.addOrder(order.getOrderId(), order);
        
        // Remove the items from the cart and add to order
        ArrayList<Book> books = new ArrayList();
        for(Map.Entry entry : cart.getItems().entrySet()) {
            Book book = (Book) entry.getKey();
            OrderIO.addItem(con, customer.getEmail(), book.getBookId(), (int) entry.getValue(), date);
            cart.removeItem(book);
            CartIO.deleteItem(con, customer.getEmail(), book.getBookId());
        }
        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cart.getCartSize());
        session.setAttribute("customer", customer);
        session.setAttribute("orders", customer.getOrders());
    }
    
    public static void getOrders(HttpServletRequest request, Connection con) throws SQLException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String email = customer.getEmail();
        Map<Integer, Order> orders = OrderIO.getOrders(con, email);
        
        session.setAttribute("orders", orders);
    }
    
    public static boolean checkout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if(customer == null) {
            session.setAttribute("checkoutError", "Please register or login to checkout.");
            return false;
        } else {
            session.removeAttribute("error");
            return true;
        }
    }
    
    // Account management
    public static boolean createAccount(HttpServletRequest request, Connection con) throws SQLException {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        Customer customer = new Customer(fName, lName, email, password, userName);
        HttpSession session = request.getSession();
        
        // Save information in database
        if (CustomerIO.emailExist(con, email)) {
            session.setAttribute("error", "This email already exists. Please login");
            return false;
        } else {
            CustomerIO.add(con, customer);
            
            session.setAttribute("customer", customer);
            session.removeAttribute("error");
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null) {
                CartIO.saveCart(con, customer.getEmail(), cart);
            }

            // Send confirmation email
            String to = customer.getEmail();
            String from = "javaweb@gmail.com";
            String subject = "Panda Books Registration";
            String body = MailUtil.buildRegistrationMessage(customer);
            try {
                MailUtil.sendMail(to, from, subject, body, true);
            } catch (MessagingException e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }
    
    public static void editAccount(HttpServletRequest request, Connection con) throws SQLException {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        String email = customer.getEmail();
        CustomerIO.update(con, "fName", fName, email);
        CustomerIO.update(con, "lName", lName, email);
        CustomerIO.update(con, "username", userName, email);
        customer = CustomerIO.getCustomerByEmail(con, email);
        session.setAttribute("customer", customer);
    }
    
    public static boolean login(HttpServletRequest request, Connection con) throws SQLException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        Customer customer;
        
        // Look for username (can be the user's email) and password combination in database
        if(userName.contains("@")) {
            customer = CustomerIO.getCustomerByEmail(con, userName);
        } else {
            customer = CustomerIO.getCustomerByUsername(con, userName);
        }
        if (customer == null) {
            session.setAttribute("loginError", "Bad login/password combination");
            return false;
        }
        
        // if found but password do not match
        if (!customer.getPassword().equals(password)) {
            session.setAttribute("loginError", "Bad login/password combination");
            return false;
        }
        
        session.setAttribute("customer", customer);
        
        // Create Cart object and set as session attribute
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            CartIO.saveCart(con, customer.getEmail(), cart);
        }
        cart = CartIO.getCart(con, customer.getEmail());
        session.setAttribute("cart", cart);
        session.setAttribute("cartSize", cart.getCartSize());
        session.removeAttribute("checkoutError");
        session.removeAttribute("loginError");
        return true;
    }
    
    public static void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("cart");
        session.removeAttribute("customer");
        session.removeAttribute("cartSize");
        session.removeAttribute("error");
        session.removeAttribute("checkoutError");
        session.removeAttribute("loginError");
    }
    
    // Books

    /**
     *
     * @param con
     * @param request
     * @param column
     * @throws SQLException
     */
    public static void getBooks(Connection con, HttpServletRequest request, String column) throws SQLException {
        HttpSession session = request.getSession();
        ArrayList<Book> books;
        String value;
        if (column.equalsIgnoreCase("title")) {
            value = request.getParameter("title");
            books = BookIO.getBooksByTitle(con, value);
        } else if (column.equalsIgnoreCase("genre")) {
            value = request.getParameter("genre");
            books = BookIO.getBooksByGenre(con, value);
        } else if (column.equalsIgnoreCase("author")) {
            value = request.getParameter("author");
            books = BookIO.getBooksByAuthor(con, value);
        } else {
            books = BookIO.getAll(con);
        }
        session.setAttribute("books", books);
    }
    
    public static void browseBooks(Connection con, HttpServletRequest request, int n, Random r) throws SQLException {
        HttpSession session = request.getSession();
        ArrayList<Book> books = BookIO.getAll(con);
        int length = books.size();

        if (length < n) n = length - 1;
        
        for (int i = length - 1; i >= length - n; --i)
        {
            Collections.swap(books, i , r.nextInt(i + 1));
        }
 
        session.setAttribute("books", books.subList(length - n, length));
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
        int id = Integer.parseInt(request.getParameter("bookId"));
        HttpSession session = request.getSession();
        Book book = BookIO.getBookById(con, id);
        
        session.setAttribute("book", book);
    }
    
    public static void addFavoriteBook(Connection con, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        int id = Integer.parseInt(request.getParameter("bookId"));
        Book book = BookIO.getBookById(con, id);
        customer.addFavoriteBook(book);
        CustomerIO.addFavorite(con, Integer.toString(book.getBookId()), customer.getEmail());
        session.setAttribute("customer", customer);
    }
    
    public static void removeFromFavotite(Connection con, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        int id = Integer.parseInt(request.getParameter("bookId"));
        Book book = BookIO.getBookById(con, id);
        customer.removeFavoriteBook(book);
        CustomerIO.removeFavorite(con, Integer.toString(book.getBookId()), customer.getEmail());
        session.setAttribute("customer", customer);
    }
    
    
    public static void addToWishList(Connection con, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        int id = Integer.parseInt(request.getParameter("bookId"));
        Book book = BookIO.getBookById(con, id);
        customer.addToWishList(book);
        CustomerIO.addToWishList(con, Integer.toString(book.getBookId()), customer.getEmail());
        session.setAttribute("customer", customer);
    }
    
    public static void removeFromWishList(Connection con, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        int id = Integer.parseInt(request.getParameter("bookId"));
        Book book = BookIO.getBookById(con, id);
        customer.removeFromWishList(book);
        CustomerIO.removeFromWishList(con, Integer.toString(book.getBookId()), customer.getEmail());
        session.setAttribute("customer", customer);
    }
    
    public static void addRecent(Connection con, HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
             int id = Integer.parseInt(request.getParameter("bookId"));
            Book book = BookIO.getBookById(con, id);
            customer.addRecentVisit(book);
            CustomerIO.addRecent(con, Integer.toString(book.getBookId()), customer.getEmail());
            session.setAttribute("customer", customer);
        }
    }
}
