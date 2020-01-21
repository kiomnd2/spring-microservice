package com.chapter6.search.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableBinding(SearchSink.class)
public class Receiver {


    SearchComponent searchComponent;

    /*

    @Autowired
    public Receiver(SearchComponent searchComponent)
    {
        this.searchComponent = searchComponent;
    }
*/

    /*@Bean
    private Queue queue() {
        return new Queue("SearchQ",false);
    }
*/
    @ServiceActivator(inputChannel = SearchSink.INVENTORYQ)
    public void accept(Map<String,Object> fare){
        searchComponent.updateInventory((String)fare.get("FLIGHT_NUMBER"),(String)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
    }
    /*@RabbitListener(queues = "SearchQ")
    public void processMessage(Map<String,Object> fare)
    {
        System.out.println(fare);
        searchComponent.updateInventory((String)fare.get("FLIGHT_NUMBER"),(String)fare.get("FLIGHT_DATE"),(int)fare.get("NEW_INVENTORY"));
        //call repository and update the fare for the given flight
    }*/
}
