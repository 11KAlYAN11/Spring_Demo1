package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("bikeSetter") // Bean name for Setter Injection
public class Bike implements Vehicle {
    private Tyre tyre;
    
    // For Constructor Injection
    @Autowired
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
