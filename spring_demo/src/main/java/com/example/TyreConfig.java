package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TyreConfig {

    @Bean(name = "tyreMichelin")
    public Tyre tyreMichelin() {
        return new Tyre("Michelin");
    }

    @Bean(name = "tyreBridgestone")
    public Tyre tyreBridgestone() {
        return new Tyre("Bridgestone");
    }

    @Bean(name = "carConstructor")
    public Car carConstructor() {
        return new Car(tyreMichelin()); // Constructor Injection
    }

    @Bean(name = "carSetter")
    public Car carSetter() {
        Car car = new Car(); // Default constructor
        car.setTyre(tyreMichelin()); // Setter Injection
        return car;
    }

    @Bean(name = "bikeConstructor")
    public Bike bikeConstructor() {
        return new Bike(tyreBridgestone()); // Constructor Injection
    }

    @Bean(name = "bikeSetter")
    public Bike bikeSetter() {
        Bike bike = new Bike(); // Default constructor
        bike.setTyre(tyreBridgestone()); // Setter Injection
        return bike;
    }
}