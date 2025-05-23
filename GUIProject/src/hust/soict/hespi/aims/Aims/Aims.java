import hust.soict.hespi.aims.cart.Cart.Cart;
import hust.soict.hespi.aims.exception.ItemNotFoundException;
import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Playable;
import hust.soict.hespi.aims.store.Store;
import hust.soict.hespi.aims.exception.PlayerException;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ItemNotFoundException {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: viewCart(); break;
                case 0:
                    System.out.println("Thank you for using AIMS!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore() {
        while (true) {
            store.displayStore();
            storeMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        mediaDetails(media);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    title = scanner.nextLine();
                    media = store.searchByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    title = scanner.nextLine();
                    media = store.searchByTitle(title);
                    if (media != null && media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 4:
                    cart.printCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void mediaDetails(Media media) {
        while (true) {
            mediaDetailsMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        if (choice == 1) {
            Media book = new Book(0, title, null, 0); // Tạo media mẫu
            store.addMedia(book);
            System.out.println("Added media to store.");
        } else if (choice == 2) {
            Media media = store.searchByTitle(title);
            store.removeMedia(media);
            System.out.println("Removed media from store.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void viewCart() throws ItemNotFoundException {
        while (true) {
            cart.printCart();
            cartMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID, 2. Title");
                    int filterChoice = Integer.parseInt(scanner.nextLine());
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        cart.filterById(id);
                    } else {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        cart.filterByTitle(title);
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title, 2. Cost");
                    int sortChoice = Integer.parseInt(scanner.nextLine());
                    if (sortChoice == 1) {
                        cart.sortByTitle();
                    } else {
                        cart.sortByCost();
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String title = scanner.nextLine();
                    Media media = cart.searchByTitle(title);
                    cart.removeMedia(media);
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    title = scanner.nextLine();
                    media = cart.searchByTitle(title);
                    if (media != null && media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Media cannot be played or not found.");
                    }
                    break;
                case 5:
                    System.out.println("Order has been placed.");
                    cart.clear();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
