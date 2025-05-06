package com.example;

public class Car implements Vehicle {
    private Tyre tyre;

    // Constructor for Constructor Injection
    public Car(Tyre tyre) {
        this.tyre = tyre;
    }

    // Default constructor for Setter Injection
    public Car() {
    }

    // Setter for Setter Injection
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + tyre);
    }
}