package com.cognizant.skillspring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("===============================================================");
        System.out.println("  Cognizant SkillSpring Employee REST API Started Successfully ");
        System.out.println("  Endpoints available at: http://localhost:8080/api/v1/employees");
        System.out.println("===============================================================");
    }
}
