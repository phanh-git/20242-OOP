package hust.soict.hespi.aims.screen.customer.controller;

import hust.soict.hespi.aims.cart.Cart.Cart;
import hust.soict.hespi.aims.exception.ItemNotFoundException;
import hust.soict.hespi.aims.exception.PlayerException;
import hust.soict.hespi.aims.media.Media;
import hust.soict.hespi.aims.media.Playable;
import hust.soict.hespi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class CartController {

    private Cart cart;
    private Store store;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }


    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TextField searchField;

    @FXML
    public void initialize() {
        // Cài đặt cách hiển thị dữ liệu lên từng cột
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
            updateTotalCost();
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        updateButtonBar(newValue);
                    }
                }
        );
    }

    private void updateButtonBar(Media newValue) {
            if (newValue == null) {
                btnPlay.setVisible(false);
                btnRemove.setVisible(false);
            } else {
                btnRemove.setVisible(true);
                if (newValue instanceof Playable) {
                    btnPlay.setVisible(true);
                } else {
                    btnPlay.setVisible(false);
                }
            }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            ((Playable) selectedMedia).play();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) throws ItemNotFoundException {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));  // truyền lại store và cart
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTotalCost() {
        float total = 0;
        for (Media media : cart.getItemsOrdered()) {
            total += media.getCost();
        }
        costLabel.setText(String.format("Total cost: $%.2f", total));
    }

    @FXML
    private ListView<Media> mediaListView;

    @FXML
    private void handlePlaceOrder() {
        cart.clear();
        mediaListView.getItems().clear();
        updateTotalCost();
        showAlert("Order placed successfully!");
    }

    private void showAlert(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
//    @FXML
//    public void onFilterByTitleButtonClicked() {
//        String keyword = searchField.getText();
//        ObservableList<Media> filtered = cart.filterByTitle(keyword);
//        mediaListView.setItems(filtered);
//    }
    @FXML
    private TableView<Media> tableView;
    @FXML
    private void handleRemoveMedia() {
        Media selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                cart.removeMedia(selected);  // có thể ném ItemNotFoundException
            } catch (ItemNotFoundException e) {
                showAlert("Lỗi", e.getMessage());
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
