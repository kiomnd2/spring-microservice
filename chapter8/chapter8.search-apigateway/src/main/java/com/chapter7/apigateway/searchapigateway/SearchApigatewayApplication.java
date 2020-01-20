package com.chapter7.apigateway.searchapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class SearchApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApigatewayApplication.class, args);
    }


    public CustomZuulFilter customFilter() {
        return new CustomZuulFilter();
    }
}
