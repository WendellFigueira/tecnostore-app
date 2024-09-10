package com.example.tecnostore.objetos;

public class Product {
    private String name;
    private String description;
    private int imageResId; // Referência da imagem (R.drawable)
    private double price;

    public Product(String name, String description, int imageResId, double price) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public double getPrice(){
        return price;
    }
}
