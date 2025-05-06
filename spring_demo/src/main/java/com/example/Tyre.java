package com.example;
import org.springframework.stereotype.Component;

//@Component("tyre") // Bean name will be "tyre"
public class Tyre {
    private String brand = "MRF"; // Default value for annotation-based DI

    public Tyre() {
    }

    public Tyre(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Tyre [brand=" + brand + "]";
    }
}
