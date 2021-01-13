package io.nextree.javafx.bill2.view;

import io.nextree.javafx.bill2.model.OrderMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderView extends HBox implements Initializable {
    //
    @FXML private ComboBox<OrderMenu> menuComboBox;
    @FXML private TextField priceTextField;
    @FXML private TextField quantityTextField;

    public OrderView() {
        //
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/OrderView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //

        Platform.runLater(() -> {
            //
            menuComboBox.getItems().addAll(OrderMenu.values());
            menuComboBox.getSelectionModel().selectFirst();
        });
    }
}
