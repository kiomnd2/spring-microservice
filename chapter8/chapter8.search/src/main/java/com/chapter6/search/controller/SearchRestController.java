package com.chapter6.search.controller;

import com.chapter6.search.component.SearchComponent;
import com.chapter6.search.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RefreshScope
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchRestController {

    private SearchComponent searchComponent;

    @Value("${originairports.shutdown}")
    private String originAirportShutdownList;

    @Autowired
    SearchRestController(SearchComponent searchComponent)
    {
        this.searchComponent = searchComponent;
    }


    @RequestMapping(value="/get", method= RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query)
    {
        System.out.println("Input : " + query);
        if(Arrays.asList(originAirportShutdownList.split(",")).contains(query.getOrigin()))
        {
            System.out.println("The origin airport is in shutdown state");
            return new ArrayList<Flight>();
        }

        return searchComponent.search(query);
    }

}

