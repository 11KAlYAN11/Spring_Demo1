package com.example;

// Correct imports for Spring classes
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");

        // Test Car with Constructor Injection
        Vehicle carConstructor = context.getBean("carConstructor", Vehicle.class);
        System.out.println("Car (Constructor Injection):");
        carConstructor.drive();

        // Test Bike with Setter Injection
        Vehicle bikeSetter = context.getBean("bikeSetter", Vehicle.class);
        System.out.println("Bike (Setter Injection):");
        bikeSetter.drive();
    }
}