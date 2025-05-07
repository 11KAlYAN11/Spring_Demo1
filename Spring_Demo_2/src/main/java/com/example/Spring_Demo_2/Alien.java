package com.example.Spring_Demo_2;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Alien {
   /*  public void code() {
        System.out.println("I'm Coding...");
    } */

    @Autowired
    Laptop lap;
    public void code() {
        lap.compile();
    }
}
