/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */

package panda.books.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private static int count = 1;
     public enum Status {
        SUBMITTED, RECEIVED, SHIPPED, DELIVERED, CANCELLED
    }
     
    private int orderId;
    private Map<Book, Integer> items;
    private double totalCost;
    private Status orderStatus;
    private Date orderDate;
    private Date statusDate;
    
    public Order() {
        this.items = new HashMap();
    }
    
    public Order(int orderId) {
        this.items = new HashMap();
        this.orderId = orderId;
    }
    
    public Order(Date orderDate) {
        this.items = new HashMap();
        this.orderStatus = Status.SUBMITTED;
        this.orderDate = orderDate;
        this.statusDate = orderDate;
    }

    public Order(int orderId, Map<Book, Integer> items, double totalCost, Status orderStatus) {
        this.items = items;
        this.totalCost = totalCost;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Map<Book, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Book, Integer> items) {
        this.items = items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        if (orderStatus.equalsIgnoreCase("Submitted")) {
            this.orderStatus = Status.SUBMITTED;
        } else if (orderStatus.equalsIgnoreCase("Received")) {
            this.orderStatus = Status.RECEIVED;
        } else if (orderStatus.equalsIgnoreCase("Shipped")) {
            this.orderStatus = Status.SHIPPED;
        } else if (orderStatus.equalsIgnoreCase("Delivered")) {
            this.orderStatus = Status.DELIVERED;
        } else if (orderStatus.equalsIgnoreCase("Cancelled")) {
            this.orderStatus = Status.CANCELLED;
        }
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }
    
    public void addItem(Book book, int qty) {
        this.items.put(book, qty);
    }
    
    public void removeItem(Book book) {
        this.items.remove(book);
    }
    
    public void computeTotalCharges() {
        totalCost = 0.0;
        totalCost = items.entrySet().stream().map((entry) -> entry.getKey().getPrice() * entry.getValue()).reduce(totalCost, (accumulator, _item) -> accumulator + _item);
    }
}
