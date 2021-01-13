package io.nextree.javafx.bill2.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    //
    private List<Order> orders;
    private int totalPrice;

    public Bill() {
        //
        this.orders = new ArrayList<>();
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
