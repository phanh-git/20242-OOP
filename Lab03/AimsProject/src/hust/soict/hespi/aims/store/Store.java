package hust.soict.hespi.aims.store;

import hust.soict.hespi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media item) {
        if (!itemsInStore.contains(item)) {
            itemsInStore.add(item);
            System.out.println("Added: " + item.getTitle());
        } else {
            System.out.println("Item already exists in store: " + item.getTitle());
        }
    }

    public void removeMedia(Media item) {
        if (itemsInStore.contains(item)) {
            itemsInStore.remove(item);
            System.out.println("Removed: " + item.getTitle());
        } else {
            System.out.println("Item not found: " + item.getTitle());
        }
    }

    // Hiển thị tất cả media trong cửa hàng
    public void displayStore() {
        System.out.println("=== Store Inventory ===");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsInStore, (media1, media2) -> media1.getTitle().compareToIgnoreCase(media2.getTitle()));
    }

    public void sortByCost() {
        Collections.sort(itemsInStore, (media1, media2) -> Double.compare(media1.getCost(), media2.getCost()));
    }

    // Tìm media theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                return media;
            }
        }
        return null;
    }

    // Tìm media theo ID
    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
}
