package com.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServerLab2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerLab2Application.class, args);
    }
}
