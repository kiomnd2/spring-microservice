package com.chapter7.apigateway.checkinapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class CheckinApigatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CheckinApigatewayApplication.class, args);
    }

}
