package panda.books.business;

import java.util.Map;
/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class Order {
     private enum Status {
        SUBMITTED, RECEIVED, SHIPPED, DELIVERED, CANCELLED
    }
    private int orderId;
    private Map<String, Integer> items;
    private double totalCost;
    private Status orderStatus;

    public Order(int orderId, Map<String, Integer> items, double totalCost, Status orderStatus) {
        this.orderId = orderId;
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

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
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

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
