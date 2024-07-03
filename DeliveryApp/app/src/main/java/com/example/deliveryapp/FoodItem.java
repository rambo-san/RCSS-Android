package com.example.deliveryapp;

public class FoodItem {
    private int imageResourceId;
    private String name;
    private String description;
    private String price;

    public FoodItem(int imageResourceId, String name, String description, String price) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
