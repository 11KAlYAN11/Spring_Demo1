package com.example.Spring_Demo_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDemo2Application.class, args);

		Alien obj = context.getBean(Alien.class);

		obj.code();
	}

}
