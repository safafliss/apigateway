package tn.esprit.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/formations/**")
                        .uri("http://formation:8088/")

                )
                .route(r -> r.path("/api/candidats/**")
                        .uri("http://candidat:8081/")

                )
                .route(r -> r.path("/user/**")
                        .uri("http://app:3000/") // Replace with the actual host and port of your user-service
                )
                .route(r -> r.path("/apigateway/**") // Add a route for the image app
                        .uri("http://apigateway:8082/") // Replace with the actual host and port of your image app
                )
                .build();
    }

}
