package com.example.restaurant.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String customerName;
    private LocalDateTime orderDate;
    private List<OrderItem> items = new ArrayList<>();

    private Order() {} // Приватный конструктор для Builder

    public static class Builder {
        private Order order = new Order();
        public Builder() { order.orderDate = LocalDateTime.now(); }
        public Builder setCustomer(String name) { order.customerName = name; return this; }
        public Builder addItem(MenuItem item, int qty) {
            order.items.add(new OrderItem(0, 0, item, qty));
            return this;
        }
        public Order build() { return order; }
    }

    // Getters
    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public List<OrderItem> getItems() { return items; }
    public double getTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getSubTotal).sum();
    }
}