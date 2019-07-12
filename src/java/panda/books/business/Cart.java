package panda.books.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class Cart implements Serializable {
    private Map<String, Integer> items;
    private double total;

    public Cart() {
        items = new HashMap();
        total = 0.0;
    }

    public Cart(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
