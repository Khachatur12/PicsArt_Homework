package com.exam.models;

public class Taxi {
    private String model;
    private String country;
    private int year;
    private int milage;
    private boolean isSport;
    private int weight;
    private int topSpeed;
    private int seats;
    private double cost;

    public Taxi() {
    }

    public Taxi(String name, String country, int year, int milage, boolean isSport, int weight, int topSpeed, byte seat, double cost) {
        this.model = name;
        this.country = country;
        this.year = year;
        this.milage = milage;
        this.isSport = isSport;
        this.weight = weight;
        this.topSpeed = topSpeed;
        this.seats = seat;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMilage() {
        return milage;
    }
    public void setMilage(int milage) {
        this.milage = milage;
    }
    public boolean isSport() {
        return isSport;
    }
    public void setSport(boolean sport) {
        isSport = sport;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getTopSpeed() {
        return topSpeed;
    }
    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "model='" + model + '\'' +
                ", country='" + country + '\'' +
                ", year=" + year +
                ", milage=" + milage +
                ", isSport=" + isSport +
                ", weight=" + weight +
                ", topSpeed=" + topSpeed +
                ", seats=" + seats +
                ", cost=" + cost +
                '}';
    }
}
