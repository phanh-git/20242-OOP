package hust.soict.hespi.aims.store;
import hust.soict.hespi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Matrix", "Science Fiction", "Wachowski", 120, 15.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);

        store.displayStore();

        store.removeMedia(dvd1);

        store.displayStore();
    }
}

