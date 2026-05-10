package com.example.jparepodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaRepoDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaRepoDemoApplication.class, args);
        System.out.println("\nEmployee Management System Application has started\nGo to http://localhost:8080/ port in the url or type this same in Postman to perform actions\n");
    }

}
