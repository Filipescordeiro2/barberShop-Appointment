package com.fscordeiro.apiGateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig  {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("client-service", r -> r.path("/clients/**")
                        .uri("http://localhost:8081"))
                .route("barbershop-service", r -> r.path("/barbershops/**")
                        .uri("http://localhost:8082"))
                .route("professional-service", r -> r.path("/professionals/**")
                        .uri("http://localhost:8083"))
                .route("schedule-service", r -> r.path("/schedules/**")
                        .uri("http://localhost:8084"))
                .route("appointment-orchestrator-service", r -> r.path("/orchestrator/**")
                        .uri("http://localhost:8085"))
                .route("appointment-service", r -> r.path("/appointments/**")
                        .uri("http://localhost:8086"))
                .build();
    }
}
