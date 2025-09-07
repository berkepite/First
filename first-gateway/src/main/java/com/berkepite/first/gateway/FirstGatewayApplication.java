package com.berkepite.first.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FirstGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstGatewayApplication.class, args);
	}

}
