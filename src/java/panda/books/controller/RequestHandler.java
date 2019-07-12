package panda.books.controller;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class RequestHandler {
    private static String action;
    private static String url;

    public static void executAction() {
        if (action == null || "".equals(action)) {
            // default action
            action = "home";
        }
        
        if (action.equalsIgnoreCase("home")) {
            url = "/index.jsp";
        } else if (action.equalsIgnoreCase("browse")) {
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("addToCart")) {
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("viewCart")) {
            url = "/cart.jsp";
        } else if (action.equalsIgnoreCase("checkout")) {
            url = "/order.jsp";
        } else if (action.equalsIgnoreCase("register")) {
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("login")) {
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("addToWishList")) {
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("viewWishlist")) {
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("addToFavorites")) {
            url = "/account.jsp";
        } else if (action.equalsIgnoreCase("logout")) {
            url = "/index.jsp";
        } else if (action.equalsIgnoreCase("search")) {
            url = "/books.jsp";
        } else if (action.equalsIgnoreCase("viewOrders")) {
            url = "/order.jsp";
        }
    }
    
    public static String getAction() {
        return action;
    }

    public static void setAction(String action) {
        RequestHandler.action = action;
    }
    
    public static String getUrl() {
        return url;
    }
}
