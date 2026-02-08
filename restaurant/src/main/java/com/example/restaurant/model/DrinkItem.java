package com.example.restaurant.model;

public class DrinkItem extends MenuItem {
    private boolean alcoholic;

    public DrinkItem() { super(); }

    public DrinkItem(String name, double price, boolean alcoholic) {
        super(name, price, "DRINK");
        this.alcoholic = alcoholic;
    }

    @Override
    public String getDescription() {
        return "Drink: " + getName() + (alcoholic ? " (Alcoholic)" : "");
    }

    public boolean isAlcoholic() { return alcoholic; }
    public void setAlcoholic(boolean alcoholic) { this.alcoholic = alcoholic; }
}