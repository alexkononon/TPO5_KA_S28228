package org.example.tpo5_ka_s28228.model;

public class Car {
    private final String type;
    private final String brand;
    private final int year;
    private final double fuelConsumption;

    public Car(String type, String brand, int year, double fuelConsumption) {
        this.type = type;
        this.brand = brand;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
    }
    public String getType() { return type; }
    public String getBrand() { return brand; }
    public int getYear() { return year; }
    public double getFuelConsumption() { return fuelConsumption; }
}
