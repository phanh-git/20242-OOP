package hust.soict.hespi.aims.test.disc;

import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class TestPolymorphism {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        Media dvd = new DigitalVideoDisc(1, "Avengers", "Action", "Marvel", 120, 19.99f);
        Media cd = new CompactDisc(2, "Best Hits", "Pop", 15.99f, "Various", null);
        Media book = new Book(3, "Clean Code", "Programming", 39.99f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
