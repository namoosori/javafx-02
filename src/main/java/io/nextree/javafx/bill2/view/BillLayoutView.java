package io.nextree.javafx.bill2.view;

import io.nextree.javafx.bill2.model.Bill;
import io.nextree.javafx.bill2.model.Order;
import io.nextree.javafx.bill2.viewmodel.BillViewModel;
import io.nextree.javafx.bill2.viewmodel.OrderViewModel;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BillLayoutView extends BorderPane implements Initializable {
    //
    @FXML private VBox orderListVBox;
    @FXML private TextField totalTextField;

    private BillViewModel billViewModel;

    public BillLayoutView() {
        //
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BillLayout.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.billViewModel = new BillViewModel();
    }

    public void modifyBill(Bill bill) {
        //
        this.billViewModel.modifyValue(bill);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //
        Platform.runLater(() -> {
            //
            this.billViewModel.getOrders().addListener(new ListChangeListener<OrderViewModel>() {
                @Override
                public void onChanged(Change<? extends OrderViewModel> c) {
                    ObservableList<OrderViewModel> orders = billViewModel.getOrders();
                    List<OrderView> orderViews = new ArrayList<>();

                    for (OrderViewModel order : orders) {
                        orderViews.add(new OrderView(order));
                    }

                    orderListVBox.getChildren().setAll(orderViews);
                }
            });
        });
    }
}
