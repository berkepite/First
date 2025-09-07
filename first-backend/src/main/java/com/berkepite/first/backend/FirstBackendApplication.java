package com.berkepite.first.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FirstBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstBackendApplication.class, args);
    }

}
