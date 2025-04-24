package hust.soict.hespi.aims.cart.Cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import hust.soict.hespi.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // Thêm một Media vào giỏ hàng
    public void addMedia(Media media) {
        itemsOrdered.add(media);
        System.out.println(media.getTitle() + " has been added to the cart.");
    }

    // Xóa một Media khỏi giỏ hàng
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println(media.getTitle() + " has been removed from the cart.");
        } else {
            System.out.println(media.getTitle() + " is not in the cart.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    // Tính tổng chi phí của giỏ hàng
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void filterById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
            }
        }
    }

    public void filterByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media.toString());
            }
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getTitle));
        printCart();
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Comparator.comparing(Media::getCost).reversed());
        printCart();
    }

    // Phương thức để in giỏ hàng (tùy chọn, nếu cần)
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart has been emptied.");
    }
}