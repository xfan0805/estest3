package com.estest3.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.estest3.demo.*", "java"})
public class Estest3Application {

    public static void main(String[] args) {
        SpringApplication.run(Estest3Application.class, args);
    }


}
