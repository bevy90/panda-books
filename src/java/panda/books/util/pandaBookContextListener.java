package panda.books.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import panda.books.business.Book;
import panda.books.data.BookIO;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class pandaBookContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            String dbUrl = "jdbc:mysql://localhost:3306/panda_books";
//            String username = "bjeanba1";
//            String password = "WebDevJavaProject";
            String dbUrl = "jdbc:mysql://remotemysql.com:3306/IsRSUdG6OJ";
            String username = "IsRSUdG6OJ";
            String password = "qPdpYWjFlq";
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            for (Throwable t : e) {
                System.out.println(t);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pandaBookContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        sc.setAttribute("connection", connection);
        
        ArrayList<Book> books = new ArrayList();
        try {
            books = BookIO.getBooksByGenre(connection, "Mystery");
        } catch (SQLException ex) {
            Logger.getLogger(pandaBookContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        sc.setAttribute("books", books);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        
        Connection connection = (Connection) sc.getAttribute("connection");
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(pandaBookContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
