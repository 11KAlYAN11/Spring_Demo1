package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car implements Vehicle {
    private Tyre tyre;

    // Constructor for Constructor Injection
    @Autowired
    public Car(@Qualifier("tyreMichelin") Tyre tyre) {
        this.tyre = tyre;
    }

    // Default constructor for Setter Injection
    public Car() {
    }

    // Setter for Setter Injection
    @Autowired
    @Qualifier("tyreMichelin")
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + tyre);
    }
}