package hust.soict.hespi.aims.screen.customer.view;

import hust.soict.hespi.aims.cart.Cart.Cart;
import hust.soict.hespi.aims.exception.PlayerException;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import javax.swing.*;

public class ItemController {
    private Cart cart;
    private Media media;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.valueOf(media.getCost()));
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (media != null && cart != null) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " added to cart.");
        } else {
            System.out.println("Error: media or cart is null.");
        }
    }

    @FXML
    private ListView<Media> mediaListView;

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        Media selected = mediaListView.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            ((Playable) selected).play();
        } else {
            showAlert("This media is not playable.");
        }
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }

}
