package com.example;

// Correct imports for Spring classes
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Test Car with Constructor Injection
        Vehicle carConstructor = context.getBean("carConstructor", Vehicle.class);
        System.out.println("Car (Constructor Injection):");
        carConstructor.drive();

        // Test Car with Setter Injection
        Vehicle carSetter = context.getBean("carSetter", Vehicle.class);
        System.out.println("Car (Setter Injection):");
        carSetter.drive();

        // Test Bike with Constructor Injection
        Vehicle bikeConstructor = context.getBean("bikeConstructor", Vehicle.class);
        System.out.println("Bike (Constructor Injection):");
        bikeConstructor.drive();

        // Test Bike with Setter Injection
        Vehicle bikeSetter = context.getBean("bikeSetter", Vehicle.class);
        System.out.println("Bike (Setter Injection):");
        bikeSetter.drive();
    }
}