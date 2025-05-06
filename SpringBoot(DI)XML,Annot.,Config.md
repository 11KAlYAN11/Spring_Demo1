🌟 Spring Dependency Injection (DI) Configurations: Your Ultimate Guide 🌟
Welcome to your one-stop reference for Spring DI Configurations! 🎉 This guide covers the three DI approaches we explored in the spring-demo project: XML-Based, Annotation-Based, and Java-Based. Each section is packed with key files, descriptions, and outputs, styled to make learning fun and easy to revisit. Let’s dive in! 🚀

📜 1. XML-Based Configuration
🔍 What’s This About?Beans and their dependencies are defined in an XML file (applicationContext.xml). The Spring container uses this file to create and wire beans—think of it as a blueprint for your app! 🗺️
📂 Key Files
applicationContext.xml (src/main/resources/applicationContext.xml)
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Tyre Beans -->
    <bean id="tyreMichelin" class="com.example.Tyre">
        <constructor-arg value="Michelin"/>
    </bean>
    <bean id="tyreBridgestone" class="com.example.Tyre">
        <constructor-arg value="Bridgestone"/>
    </bean>

    <!-- Car Beans -->
    <bean id="carConstructor" class="com.example.Car">
        <constructor-arg ref="tyreMichelin"/>
    </bean>
    <bean id="carSetter" class="com.example.Car">
        <property name="tyre" ref="tyreMichelin"/>
    </bean>

    <!-- Bike Beans -->
    <bean id="bikeConstructor" class="com.example.Bike">
        <constructor-arg ref="tyreBridgestone"/>
    </bean>
    <bean id="bikeSetter" class="com.example.Bike">
        <property name="tyre" ref="tyreBridgestone"/>
    </bean>
</beans>

Car.java (src/main/java/com/example/Car.java)
package com.example;

public class Car implements Vehicle {
    private Tyre tyre;

    public Car(Tyre tyre) {
        this.tyre = tyre;
    }

    public Car() {
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + tyre);
    }
}

Bike.java (src/main/java/com/example/Bike.java)
package com.example;

public class Bike implements Vehicle {
    private Tyre tyre;

    public Bike(Tyre tyre) {
        this.tyre = tyre;
    }

    public Bike() {
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike with " + tyre);
    }
}

App.java (src/main/java/com/example/App.java)
package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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

Tyre.java (src/main/java/com/example/Tyre.java)
package com.example;

public class Tyre {
    private String brand;

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

Vehicle.java (src/main/java/com/example/Vehicle.java)
package com.example;

public interface Vehicle {
    void drive();
}

🎯 Expected Output
Car (Constructor Injection):
Driving a car with Tyre [brand=Michelin]
Car (Setter Injection):
Driving a car with Tyre [brand=Michelin]
Bike (Constructor Injection):
Riding a bike with Tyre [brand=Bridgestone]
Bike (Setter Injection):
Riding a bike with Tyre [brand=Bridgestone]


🖌️ 2. Annotation-Based Configuration (@Component, @Autowired, @Qualifier)
🔍 What’s This About?Beans are marked with @Component, and dependencies are injected using @Autowired and @Qualifier. Spring scans for these annotations to wire beans automatically—less boilerplate, more magic! ✨
📂 Key Files
TyreConfig.java (src/main/java/com/example/TyreConfig.java)
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
}

Car.java (src/main/java/com/example/Car.java)
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carConstructor")
public class Car implements Vehicle {
    private Tyre tyre;

    @Autowired
    public Car(@Qualifier("tyreMichelin") Tyre tyre) {
        this.tyre = tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + tyre);
    }
}

CarSetter.java (src/main/java/com/example/CarSetter.java)
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carSetter")
public class CarSetter implements Vehicle {
    private Tyre tyre;

    @Autowired
    @Qualifier("tyreMichelin")
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + tyre);
    }
}

Bike.java (src/main/java/com/example/Bike.java)
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bikeSetter")
public class Bike implements Vehicle {
    private Tyre tyre;

    public Bike() {
    }

    @Autowired
    @Qualifier("tyreBridgestone")
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike with " + tyre);
    }
}

BikeConstructor.java (src/main/java/com/example/BikeConstructor.java)
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bikeConstructor")
public class BikeConstructor implements Vehicle {
    private Tyre tyre;

    @Autowired
    public BikeConstructor(@Qualifier("tyreBridgestone") Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike with " + tyre);
    }
}

App.java (src/main/java/com/example/App.java)
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

Tyre.java (src/main/java/com/example/Tyre.java)
package com.example;

public class Tyre {
    private String brand;

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

Vehicle.java (src/main/java/com/example/Vehicle.java)
package com.example;

public interface Vehicle {
    void drive();
}

🎯 Expected Output
Car (Constructor Injection):
Driving a car with Tyre [brand=Michelin]
Car (Setter Injection):
Driving a car with Tyre [brand=Michelin]
Bike (Constructor Injection):
Riding a bike with Tyre [brand=Bridgestone]
Bike (Setter Injection):
Riding a bike with Tyre [brand=Bridgestone]


💡 Note: Later, we simplified this by removing CarSetter.java and BikeConstructor.java, merging both injection types into Car.java and Bike.java.


☕ 3. Java-Based Configuration (@Configuration, @Bean)
🔍 What’s This About?All beans and dependencies are defined in a Java class using @Configuration and @Bean. No XML or annotations in the classes—everything is centralized in Java! 🛠️
📂 Key Files
TyreConfig.java (src/main/java/com/example/TyreConfig.java)
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
        return new Car(tyreMichelin());
    }

    @Bean(name = "carSetter")
    public Car carSetter() {
        Car car = new Car();
        car.setTyre(tyreMichelin());
        return car;
    }

    @Bean(name = "bikeConstructor")
    public Bike bikeConstructor() {
        return new Bike(tyreBridgestone());
    }

    @Bean(name = "bikeSetter")
    public Bike bikeSetter() {
        Bike bike = new Bike();
        bike.setTyre(tyreBridgestone());
        return bike;
    }
}

Car.java (src/main/java/com/example/Car.java)
package com.example;

public class Car implements Vehicle {
    private Tyre tyre;

    public Car(Tyre tyre) {
        this.tyre = tyre;
    }

    public Car() {
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Driving a car with " + tyre);
    }
}

Bike.java (src/main/java/com/example/Bike.java)
package com.example;

public class Bike implements Vehicle {
    private Tyre tyre;

    public Bike(Tyre tyre) {
        this.tyre = tyre;
    }

    public Bike() {
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }

    @Override
    public void drive() {
        System.out.println("Riding a bike with " + tyre);
    }
}

App.java (src/main/java/com/example/App.java)
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

Tyre.java (src/main/java/com/example/Tyre.java)
package com.example;

public class Tyre {
    private String brand;

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

Vehicle.java (src/main/java/com/example/Vehicle.java)
package com.example;

public interface Vehicle {
    void drive();
}

🎯 Expected Output
Car (Constructor Injection):
Driving a car with Tyre [brand=Michelin]
Car (Setter Injection):
Driving a car with Tyre [brand=Michelin]
Bike (Constructor Injection):
Riding a bike with Tyre [brand=Bridgestone]
Bike (Setter Injection):
Riding a bike with Tyre [brand=Bridgestone]


🛠️ Common Files Across All Configurations
pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>spring-demo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>17</maven.compiler.source>
        <maven.compiler.target>17</maven.compiler.target>
        <spring.version>6.1.5</spring.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.10.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>com.example.App</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

🖥️ Compile and Run Commands
For each configuration:
cd /home/pavan/javaPS/Spring_Demo1/spring_demo
mvn clean compile
mvn exec:java


📊 Comparison Table



Configuration
Pros
Cons



XML-Based 📜
Centralized, explicit control
Verbose, error-prone, less modern


Annotation-Based 🖌️
Less boilerplate, intuitive
Scattered config, harder to debug


Java-Based ☕
Centralized, type-safe, flexible
Slightly more code than annotations



🚀 Key Takeaways

XML-Based: Your blueprint for explicit control—great for legacy projects! 🗺️
Annotation-Based: Sprinkle some magic with @Component and @Autowired—perfect for quick setups! ✨
Java-Based: The best of both worlds—centralized like XML, but in Java! 🛠️

Happy coding! 🎉 Keep this guide handy for your Spring adventures! 🌟
