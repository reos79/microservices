package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryServerLab3Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryServerLab3Application.class, args);
    }
}
