package hust.soict.hespi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();
    private static int nbBooks = 0;

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }

    // Display method
    public void display() {
        System.out.println("Book: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Authors: " + String.join(", ", authors));
        System.out.println("Cost: " + getCost() + "$");
        System.out.println("Content length (estimated): " + (getTitle().length() + authors.size() * 10));
    }
}
