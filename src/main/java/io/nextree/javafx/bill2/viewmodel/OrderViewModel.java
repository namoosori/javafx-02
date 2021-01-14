package io.nextree.javafx.bill2.viewmodel;

import io.nextree.javafx.bill2.model.Order;
import io.nextree.javafx.bill2.model.OrderMenu;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class OrderViewModel {
    //
    private SimpleObjectProperty<OrderMenu> menu;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty quantity;

    public OrderViewModel() {
        //
        this.menu = new SimpleObjectProperty<>();
        this.price = new SimpleIntegerProperty();
        this.quantity = new SimpleIntegerProperty();
    }

    public OrderViewModel(Order order) {
        //
        this();
        this.menu.set(order.getMenu());
        this.price.set(order.getPrice());
        this.quantity.set(order.getQuantity());
    }

    public void modifyValues(OrderViewModel orderViewModel) {
        //
        this.menu.set(orderViewModel.getMenu());
        this.price.set(orderViewModel.getPrice());
        this.quantity.set(orderViewModel.getQuantity());
    }

    public SimpleObjectProperty<OrderMenu> menuProperty() {
        return menu;
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public OrderMenu getMenu() {
        return menu.get();
    }

    public int getPrice() {
        return price.get();
    }

    public int getQuantity() {
        return quantity.get();
    }
}
