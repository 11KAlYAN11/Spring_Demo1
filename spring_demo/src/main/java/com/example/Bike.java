package com.example;

public class Bike implements Vehicle {
    private Tyre tyre;

    // Constructor for Constructor Injection
    public Bike(Tyre tyre) {
        this.tyre = tyre;
    }

    // Default constructor for Setter Injection
    public Bike() {
    }

    // Setter for Setter Injection
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike with " + tyre);
    }
}