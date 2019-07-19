package panda.books.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import panda.books.business.Book;
import panda.books.business.Cart;

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
    public static void modifyCart(HttpServletRequest request) {
        String bookId = request.getParameter("bookId");
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
        Book book = new Book();
        book.setTitle(bookId);
        book.setPrice(15.00);
        
        
        if (quantity > 0) {
            cart.addItem(book, quantity);
        } else if (quantity == 0) {
            cart.removeItem(book);
        }
        
        cart.computeTotalCharges();
        session.setAttribute("cart", cart);
    }
    
    public static void addToCart(HttpServletRequest request) {
        String bookId = request.getParameter("bookId");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        
        // Will change to get the product from the database
        Book book = new Book();
        book.setTitle(bookId);
        book.setPrice(15.00);
        
        for (Map.Entry b : cart.getItems().entrySet()) {
            if (((Book) b.getKey()).getTitle().equalsIgnoreCase(bookId)) {
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
    
    
}
