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
import java.util.Objects;

public class Book implements Serializable {
    // Unique identifier for a book
    private int bookId;
    // The title of the book
    private String title;
    // A short description of the book
    private String description;
    // The author of the book
    private String author;
    // The genre of the book
    private String genre;
    // where to find a picture of the book
    private String path;
    // The cost of the book
    private double price;
    // The format of the book
    private String format;

    public Book() {
        bookId = 0;
        title = description = author = "";
        genre = path = "";
        price = 0.0;
    }
    
    public Book(int bookId, String title, String description, String author, String genre, String path, double price) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.genre = genre;
        this.path = path;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.description);
        hash = 73 * hash + Objects.hashCode(this.author);
        hash = 73 * hash + Objects.hashCode(this.genre);
        hash = 73 * hash + Objects.hashCode(this.path);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.format);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.author, other.author);
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
    
}
