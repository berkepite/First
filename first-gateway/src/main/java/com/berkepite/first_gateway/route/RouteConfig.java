package com.berkepite.first_gateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/home")
                        .filters(f -> f.addRequestHeader("Hello", "World")
                                .rewritePath("/home", "/api/v1/todo/get"))
                        .uri("http://localhost:8080/"))
                .build();
    }
}
