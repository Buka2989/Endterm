package com.example.restaurant.patterns;

import com.example.restaurant.model.*;

public class MenuItemFactory {
    public static MenuItem createItem(String type, String name, double price, boolean attr) {
        if (type.equalsIgnoreCase("FOOD")) return new FoodItem(name, price, attr);
        if (type.equalsIgnoreCase("DRINK")) return new DrinkItem(name, price, attr);
        throw new IllegalArgumentException("Unknown type: " + type);
    }
}