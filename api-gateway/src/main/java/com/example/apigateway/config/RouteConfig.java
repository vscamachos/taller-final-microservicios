package com.example.apigateway.config;

import com.example.apigateway.security.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    private final JwtAuthenticationFilter filter;

    public RouteConfig(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator createRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("bank-service-route", route -> route
                        .path("/api/banks/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8081"))
                .route("account-service-route", route -> route
                        .path("/api/accounts/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8082"))
                .route("transaction-service-route", route -> route
                        .path("/api/transactions/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8083"))
                .route("auth-service-route", route -> route
                        .path("/api/auth/**")
                        .uri("http://localhost:8084"))
                .route("transfer-service-route", route -> route
                        .path("/api/transactions/**")
                        .filters(f -> f.filter(filter))
                        .uri("http://localhost:8086"))
                .build();
    }
}