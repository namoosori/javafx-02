package io.nextree.javafx.bill2.view;

import io.nextree.javafx.bill2.model.OrderMenu;
import io.nextree.javafx.bill2.viewmodel.OrderViewModel;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderView extends HBox implements Initializable {
    //
    @FXML private ComboBox<OrderMenu> menuComboBox;
    @FXML private TextField priceTextField;
    @FXML private TextField quantityTextField;

    private OrderViewModel orderViewModel;

    public OrderView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/OrderView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.orderViewModel = new OrderViewModel();
    }

    public OrderView(OrderViewModel orderViewModel) {
        //
        this();
        this.orderViewModel.modifyValues(orderViewModel);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
        Platform.runLater(() -> {
            //
            menuComboBox.getItems().addAll(OrderMenu.values());
            menuComboBox.getSelectionModel().selectFirst();

            menuComboBox.valueProperty().bindBidirectional(orderViewModel.menuProperty());
            priceTextField.textProperty().bindBidirectional(orderViewModel.priceProperty(), new NumberStringConverter());
            quantityTextField.textProperty().bindBidirectional(orderViewModel.quantityProperty(), new NumberStringConverter());
        });
    }
}
