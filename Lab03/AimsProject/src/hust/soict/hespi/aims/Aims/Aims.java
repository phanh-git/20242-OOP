package hust.soict.hespi.aims.Aims;

import hust.soict.hespi.aims.store.Store;

import java.util.Scanner;

public class Aims {

    // Phương thức hiển thị menu chính
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
    // Phương thức hiển thị menu cửa hàng
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

    // Phương thức hiển thị menu chi tiết của media
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    // Phương thức chính (main) để điều khiển chương trình
    public static void main(String[] args) {
        // Tạo một đối tượng Store
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        boolean running = true; // Biến điều khiển vòng lặp
        while (running) {
            showMenu();  // Hiển thị menu
            int choice = scanner.nextInt();  // Nhập lựa chọn của người dùng

            switch (choice) {
                case 1:
                    // Hiển thị cửa hàng
                    store.displayStore();
                    break;
                case 2:
                    // Cập nhật cửa hàng
                    store.updateStore();
                    break;
                case 3:
                    // Xem giỏ hàng hiện tại
                    cart.printCart();
                    break;
                case 0:
                    // Thoát chương trình
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 3.");
                    break;
            }
        }

        scanner.close(); // Đóng scanner khi thoát khỏi chương trình
    }
}


