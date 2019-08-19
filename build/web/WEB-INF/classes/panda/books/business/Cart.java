/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */

package panda.books.business;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private Map<Book, Integer> items;
    private double total;

    public Cart() {
        items = new HashMap();
        total = 0.0;
    }

    public Cart(Map<Book, Integer> items) {
        this.items = items;
    }

    public Map<Book, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Book, Integer> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public int getCartSize() {
        int size = 0;
        size = items.entrySet().stream().map((entry) -> entry.getValue()).reduce(size, (accumulator, _item) -> accumulator + _item);
        return size;
    }
    
    public void addItem(Book book, int qty) {
        this.items.put(book, qty);
    }
    
    public void removeItem(Book book) {
        this.items.remove(book);
    }
    
    public void computeTotalCharges() {
        total = 0.0;
        total = items.entrySet().stream().map((entry) -> entry.getKey().getPrice() * entry.getValue()).reduce(total, (accumulator, _item) -> accumulator + _item);
    }
}
