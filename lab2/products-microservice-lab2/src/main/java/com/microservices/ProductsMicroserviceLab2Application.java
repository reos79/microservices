package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ProductsMicroserviceLab2Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductsMicroserviceLab2Application.class, args);
    }
}
