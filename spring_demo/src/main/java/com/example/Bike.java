package com.example;

public class Bike implements Vehicle {
    private Tyre tyre;
    
    // For Constructor Injection
    public Bike(Tyre tyre) {
        this.tyre = tyre;
    }

    // For Setter Injection (we'll use this in the XML config for another bean)
    public Bike() {
    }
    
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override 
    public void drive() {
        System.out.println("Riding a bikie with "+ tyre);
    }
}
