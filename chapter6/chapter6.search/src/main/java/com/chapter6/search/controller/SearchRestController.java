package com.chapter6.search.controller;

import com.chapter6.search.component.SearchComponent;
import com.chapter6.search.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchRestController {

    private SearchComponent searchComponent;

    @Autowired
    SearchRestController(SearchComponent searchComponent)
    {
        this.searchComponent = searchComponent;
    }
    @RequestMapping(value="/get", method= RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query)
    {
        System.out.println("Input : " + query);
        return searchComponent.search(query);
    }

}

