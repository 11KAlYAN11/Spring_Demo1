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
        
    /**
     * The function sets the tyre object for a given vehicle.
     * 
     * @param tyre The `setTyre` method is used to set the `tyre` property of an object to the provided
     * `Tyre` object. This method takes a `Tyre` object as a parameter and assigns it to the `tyre`
     * property of the object.
     */
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with "+tyre);
    }
}
