package com.exercise.gateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customLocator(RouteLocatorBuilder route){
        return route.routes().route(p->p.path("/get")
                .filters(h->h.addRequestHeader("MyHeader", "TryHeader")
                        .addRequestParameter("Param", "TryParam"))
                .uri("http://httpbin.org:80")).
                route(p->p.path("/store/**").uri("lb://STOREAPPLICATION"))
                .build();
    }

}
