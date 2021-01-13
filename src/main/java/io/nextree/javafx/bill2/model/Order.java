package io.nextree.javafx.bill2.model;

public class Order {
    //
    private OrderMenu menu;
    private int price;
    private int quantity;

    public Order() {
        //
    }

    public Order(OrderMenu menu, int price, int quantity) {
        this.menu = menu;
        this.price = price;
        this.quantity = quantity;
    }

    public int computeTotalPrice() {
        //
        return price * quantity;
    }

    public OrderMenu getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
