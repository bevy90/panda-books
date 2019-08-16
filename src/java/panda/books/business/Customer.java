package panda.books.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import panda.books.data.BookIO;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class Customer implements Serializable {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String billingAddress;
    private String homeAddress;
    private String cardNumber;
    private ArrayList<Book> favoriteBooks;
    private ArrayList<Book> wishList;
    private ArrayList<Book> recentVisit;
    private Cart cart;
    private ArrayList<Order> currentOrders;
    private ArrayList<Order> pastOrders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String password, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.currentOrders = new ArrayList();
        this.pastOrders = new ArrayList();
        this.favoriteBooks = new ArrayList();
        this.wishList = new ArrayList();
        this.recentVisit = new ArrayList();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(ArrayList<Book> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }
    
    public void addFavoriteBook(Book book) {
        this.favoriteBooks.add(book);
    }
    
    public void removeFavoriteBook(Book book) {
        this.favoriteBooks.remove(book);
    }

    public ArrayList<Book> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Book> wishList) {
        this.wishList = wishList;
    }
    
    public void addToWishList(Book book) {
        this.wishList.add(book);
    }
    
    public void removeFromWishList(Book book) {
        this.wishList.remove(book);
    }

    public ArrayList<Book> getRecentVisit() {
        return recentVisit;
    }

    public void setRecentVisit(ArrayList<Book> recentVisit) {
        this.recentVisit = recentVisit;
    }
    
    public void addRecentVisit(Book book) {
        this.recentVisit.add(book);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getCurrentOrders() {
        return currentOrders;
    }
    
    public ArrayList<Order> getPastOrders() {
        return pastOrders;
    }

    public void addPastOrder(Order order) {
        this.pastOrders.add(order);
    }
    
    public void addCurrentOrder(Order order) {
        this.currentOrders.add(order);
    }
    
    public void removeCurrentOrder(Order order) {
        this.currentOrders.remove(order);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.billingAddress);
        hash = 97 * hash + Objects.hashCode(this.homeAddress);
        hash = 97 * hash + Objects.hashCode(this.cardNumber);
        hash = 97 * hash + Objects.hashCode(this.favoriteBooks);
        hash = 97 * hash + Objects.hashCode(this.wishList);
        hash = 97 * hash + Objects.hashCode(this.recentVisit);
        hash = 97 * hash + Objects.hashCode(this.cart);
        hash = 97 * hash + Objects.hashCode(this.pastOrders);
        hash = 97 * hash + Objects.hashCode(this.currentOrders);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
       return firstName + " " + lastName;
    }
    
}
