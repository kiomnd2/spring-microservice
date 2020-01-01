package com.chapter7.apigateway.searchapigateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SearchAPIGatewayController {

    @RequestMapping("/")
    String greet(HttpServletRequest req) {
        return "<h1>으아아아아아아</h1>";
    }

}
