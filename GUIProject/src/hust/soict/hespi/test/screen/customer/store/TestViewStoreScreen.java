package hust.soict.hespi.test.screen.customer.store;

import hust.soict.hespi.aims.cart.Cart.Cart;
import hust.soict.hespi.aims.media.Book;
import hust.soict.hespi.aims.media.CompactDisc;
import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hespi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Thêm media vào Store
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Avengers: Endgame", "Action", "Anthony Russo", 181, 24.99f));
        store.addMedia(new DigitalVideoDisc(3, "Frozen", "Animation", "Chris Buck", 102, 15.00f));
        store.addMedia(new DigitalVideoDisc(4, "Inception", "Sci-fi", "Christopher Nolan", 148, 22.00f));

        store.addMedia(new Book(5, "Harry Potter", "Fantasy", 29.99f));
        store.addMedia(new Book(6, "The Hobbit", "Fantasy", 19.50f));
        store.addMedia(new Book(7, "Clean Code", "Programming", 35.00f));

        store.addMedia(new CompactDisc(8, "Lo-fi Chill", "Music", 17.50f, "DJ Chill", "Lo-fi Artists"));
        store.addMedia(new CompactDisc(9, "Greatest Hits", "Pop", 21.00f, "Queen", "Various"));

        launch(args);
    }
}
