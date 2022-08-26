package com.yeahbutstill.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestParameter("MyParam", "MyValue")
                                .addRequestHeader("MyHeader", "MyURI"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/yeahbutstill/api/v1/currency-exchange/**").uri("lb://currency-exchange"))
                .route(p -> p.path("/yeahbutstill/api/v1/currency-conversion/**").uri("lb://currency-conversion"))
                .route(p -> p.path("/yeahbutstill/api/v1/currency-conversion-feign/**").uri("lb://currency-conversion"))
                .route(p -> p.path("/yeahbutstill/api/v1/currency-conversion-new/**")
                        .filters(f -> f.rewritePath("/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"))
                        .uri("lb://currency-conversion"))
                .build();

    }

}
