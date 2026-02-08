package com.example.restaurant.model;

public class OrderItem {
    private int id;
    private int orderId;
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(int id, int orderId, MenuItem menuItem, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return menuItem.getPrice() * quantity;
    }

    public MenuItem getMenuItem() { return menuItem; }
    public int getQuantity() { return quantity; }
}
