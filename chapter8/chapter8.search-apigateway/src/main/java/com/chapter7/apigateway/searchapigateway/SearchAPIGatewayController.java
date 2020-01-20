package com.chapter7.apigateway.searchapigateway;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;



@RestController
public class SearchAPIGatewayController {
    private static final Logger logger = LoggerFactory.getLogger(SearchAPIGatewayController.class);

    @LoadBalanced
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SearchAPIGatewayComponent component;

    @RequestMapping("/")
    String greet(HttpServletRequest req) {
        return "<h1>으아아아아아아</h1>";
    }



    @RequestMapping("/hubongw")
    String getHub(HttpServletRequest req)
    {
//        logger.info("Search Request in API gateway for gettinghub, forwarding to search-service");
//        String hub = restTemplate.getForObject("http://search-service/search/hub" , String.class);

//        logger.info("Response for hub received, Hub"+ hub);
        return component.getHub();
    }
}


@Component
class SearchAPIGatewayComponent{

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getDefaultHub")
    public String getHub() {
        String hub = restTemplate.getForObject("http://search-service/hub", String.class);
        return hub;
    }

    public String getDefaultHub() {
        return "Possibily SFO";
    }
}



@Configuration
class AppConfiguration{
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}