package panda.books.controller;

import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import panda.books.data.BookIO;
import panda.books.util.ConnectionPool;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class PandaBooksController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        ServletContext sc = getServletContext();
        
        String url = "/index.jsp";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        // Get current action
        String action = request.getParameter("action");
        // Perform action
        if (action == null || "".equals(action)) {
            // default action
            action = "home";
        }
        
        if (action.equalsIgnoreCase("home")) {
            url = "/index.jsp";
        } else if (action.equalsIgnoreCase("browseGenre")) {
            RequestHandler.getBooks(con, request, "genre");
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("browse")) {
            RequestHandler.getBooks(con, request, "");
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("viewBook")) {
            RequestHandler.getBookById(con, request);
            RequestHandler.addRecent(con, request);
            url = "/book.jsp";
        } else if (action.equalsIgnoreCase("addToCart")) {
            RequestHandler.addToCart(request, con);
            url = "/cart.jsp";
        } else if (action.equalsIgnoreCase("modifyCart")) {
            RequestHandler.modifyCart(request, con);
            url = "/cart.jsp";
        } else if (action.equalsIgnoreCase("checkout")) {
            url = "/checkout.jsp";
        } else if (action.equalsIgnoreCase("order")) {
            RequestHandler.processOrder(request, con);
            url = "/order.jsp";
        } else if (action.equalsIgnoreCase("register")) {
            url = "/register.jsp";
        } else if (action.equalsIgnoreCase("createAccount")) {
            if(RequestHandler.createAccount(request, con)) {
                url = "/account.jsp";
            } else {
                url = "/register.jsp";
            }
        } else if (action.equalsIgnoreCase("login")) {
            RequestHandler.login(request, con);
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("logout")) {
            RequestHandler.logout(request);
            url = "/index.jsp";
        } else if (action.equalsIgnoreCase("goToAccount")) {
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("addToWishList")) {
            RequestHandler.addToWishList(con, request);
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("addToFavorites")) {
            RequestHandler.addFavoriteBook(con, request);
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("removeFromFavorites")) {
            RequestHandler.removeFromFavotite(con, request);
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("removeFromWishList")) {
            RequestHandler.removeFromWishList(con, request);
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("search")) {
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("viewOrders")) {
            url = "/order.jsp";
        }
        
        pool.freeConnection(con);
        sc.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PandaBooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PandaBooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
