package com.company;

public class Product {
    private String name;
    private String description;
    private double price;
    private int production_date;
    private int shelf_life;
    private String manufacturer;
    private String ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProduction_date() {
        return production_date;
    }

    public void setProduction_date(int production_date) {
        this.production_date = production_date;
    }

    public int getShelf_life() {
        return shelf_life;
    }

    public void setShelf_life(int shelf_life) {
        this.shelf_life = shelf_life;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDetails() {
        return  "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", production_date=" + production_date +
                ", shelf_life=" + shelf_life +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients='" + ingredients + '\'';
    }
}