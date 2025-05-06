package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Bike implements Vehicle {
    private Tyre tyre;

    // Constructor for Constructor Injection
    @Autowired
    public Bike(@Qualifier("tyreBridgestone") Tyre tyre) {
        this.tyre = tyre;
    }

    // Default constructor for Setter Injection
    public Bike() {
    }

    // Setter for Setter Injection
    @Autowired
    @Qualifier("tyreBridgestone")
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike with " + tyre);
    }
}