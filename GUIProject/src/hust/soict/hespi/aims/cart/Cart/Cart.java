package hust.soict.hespi.aims.cart.Cart;

import java.util.Collections;
import java.util.Comparator;

import hust.soict.hespi.aims.exception.ItemNotFoundException;
import hust.soict.hespi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // Thêm một Media vào giỏ hàng
    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println(media.getTitle() + " has been added to the cart.");
    }

    // Xóa một Media khỏi giỏ hàng
    public void removeMedia(Media m) throws ItemNotFoundException {
        if (itemsOrdered.contains(m)) {
            itemsOrdered.remove(m);
        } else {
            throw new ItemNotFoundException("ERROR: Media not found in the cart");
        }
    }


    // Trả về danh sách các Media trong giỏ hàng
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // Tìm Media theo tiêu đề
    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    // Tính tổng chi phí giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Lọc theo ID
    public void filterById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media);
            }
        }
    }

    // Lọc theo tiêu đề
//    public void filterByTitle(String title) {
//        for (Media media : itemsOrdered) {
//            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
//                System.out.println(media);
//            }
//        }
//    }
    public ObservableList<Media> filterByTitle(String title) {
        if (title == null || title.isEmpty()) {
            return itemsOrdered;
        }
        ObservableList<Media> filteredList = FXCollections.observableArrayList();
        String lowerTitle = title.toLowerCase();
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(lowerTitle)) {
                filteredList.add(media);
            }
        }
        return filteredList;
    }


    // Sắp xếp theo tiêu đề (tăng dần)
    public void sortByTitle() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
        printCart();
    }

    // Sắp xếp theo giá (giảm dần)
    public void sortByCost() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost).reversed());
        printCart();
    }

    // In thông tin giỏ hàng
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    // Xóa toàn bộ giỏ hàng
    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }
}
