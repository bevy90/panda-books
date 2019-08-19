/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
package panda.books.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import panda.books.business.Book;
import panda.books.data.BookIO;

public class pandaBookContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        List<Book> books = null;
        try {
            ArrayList<Book> temp = BookIO.getAll(connection);
            books = pickFeaturedBooks(temp, 4, ThreadLocalRandom.current());
        } catch (SQLException ex) {
            Logger.getLogger(pandaBookContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pool.freeConnection(connection);
        
        sc.setAttribute("featuredBooks", books);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
    }
    
    private List<Book> pickFeaturedBooks(ArrayList<Book> books, int n, Random r) {
        int length = books.size();

        if (length < n) return null;
        
        for (int i = length - 1; i >= length - n; --i)
        {
            Collections.swap(books, i , r.nextInt(i + 1));
        }
 
        return books.subList(length - n, length);
    }
}
