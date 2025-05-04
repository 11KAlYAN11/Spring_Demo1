package com.example;

public class Car implements Vehicle {
    private Tyre tyre;

    // For Constructor Injection
    public Car(Tyre tyre) {
        this.tyre = tyre;
    }

    // For Setter Injection (we'll use this in the XML config for another bean)
    public Car() {
    }
        
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with "+tyre);
    }
}
