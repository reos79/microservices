package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class ProductsMicroserviceLab3Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductsMicroserviceLab3Application.class, args);
    }
}
