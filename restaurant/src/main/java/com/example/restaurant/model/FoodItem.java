package com.example.restaurant.model;

public class FoodItem extends MenuItem {
    private boolean spicy; // Упростили имя поля для Jackson

    public FoodItem() { super(); }

    public FoodItem(String name, double price, boolean spicy) {
        super(name, price, "FOOD");
        this.spicy = spicy;
    }

    @Override
    public String getDescription() {
        return "Food: " + getName() + (spicy ? " (Spicy)" : "");
    }

    public boolean isSpicy() { return spicy; }
    public void setSpicy(boolean spicy) { this.spicy = spicy; }
}