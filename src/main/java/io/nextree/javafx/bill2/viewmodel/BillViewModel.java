package io.nextree.javafx.bill2.viewmodel;

import io.nextree.javafx.bill2.model.Bill;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class BillViewModel {
    //
    private ObservableList<OrderViewModel> orders;
    private SimpleIntegerProperty totalPrice;

    public BillViewModel() {
        //
        this.orders = FXCollections.observableArrayList();
        this.totalPrice = new SimpleIntegerProperty();
    }

    public BillViewModel(Bill bill) {
        //
        this();
        modifyValue(bill);
    }

    public void modifyValue(Bill bill) {
        //
        List<OrderViewModel> orderViewModels = bill.getOrders().stream().map(OrderViewModel::new).collect(Collectors.toList());
        this.orders.setAll(orderViewModels);
    }

    public ObservableList<OrderViewModel> getOrders() {
        return orders;
    }
}
