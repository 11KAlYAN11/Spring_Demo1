package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TyreConfig.class);

        Vehicle carConstructor = context.getBean("carConstructor", Vehicle.class);
        System.out.println("Car (Constructor Injection):");
        carConstructor.drive();

        Vehicle carSetter = context.getBean("carSetter", Vehicle.class);
        System.out.println("Car (Setter Injection):");
        carSetter.drive();

        Vehicle bikeConstructor = context.getBean("bikeConstructor", Vehicle.class);
        System.out.println("Bike (Constructor Injection):");
        bikeConstructor.drive();

        Vehicle bikeSetter = context.getBean("bikeSetter", Vehicle.class);
        System.out.println("Bike (Setter Injection):");
        bikeSetter.drive();
    }
}