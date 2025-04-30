package hust.soict.hespi.aims.store;
import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.screen.manager.StoreManagerScreen;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        store.addMedia(new DigitalVideoDisc(1, "Harry Potter and the Philosopher's Stone", "Fantasy", "Chris Columbus", 152, 3.0f));
        store.addMedia(new DigitalVideoDisc(2, "Harry Potter and the Chamber of Secrets", "Fantasy", "Chris Columbus", 161, 3.5f));
        store.addMedia(new DigitalVideoDisc(3, "Harry Potter and the Prisoner of Azkaban", "Fantasy", "Alfonso Cuarón", 142, 5.0f));
        store.addMedia(new DigitalVideoDisc(4, "Harry Potter and the Goblet of Fire", "Fantasy", "Mike Newell", 157, 4.5f));
        store.addMedia(new CompactDisc(5, "Fetch the Bolt Cutters", "Music", 10.39f, "Fiona Apple", "Fiona Apple"));
        store.addMedia(new CompactDisc(6, "Future Nostalgia", "Music", 9.6f, "Dua Lipa", "Dua Lipa"));
        store.addMedia(new DigitalVideoDisc(7, "The Hunger Games", "Action", "Gary Ross", 142, 5.5f));
        store.addMedia(new DigitalVideoDisc(8, "Catching Fire", "Action", "Francis Lawrence", 146, 4.9f));
        store.addMedia(new DigitalVideoDisc(9, "Mockingjay", "Action", "Francis Lawrence", 137, 5.1f));

        new StoreManagerScreen(store);
    }
}

