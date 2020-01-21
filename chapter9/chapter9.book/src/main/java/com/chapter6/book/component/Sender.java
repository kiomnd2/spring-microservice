package com.chapter6.book.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(BookingSource.class)
@Component
public class Sender {

    RabbitMessagingTemplate template;

    @Output( BookingSource.InventoryQ )
    @Autowired
    private MessageChannel channel;

/*
    @Autowired
    Sender(RabbitMessagingTemplate template){
        this.template = template;
    }
    @Bean
    Queue queue() {
        return new Queue("SearchQ", false);
    }
    @Bean
    Queue queue1() {
        return new Queue("CheckINQ", false);
    }
*/


    public void send(Object message){
        /*template.convertAndSend("SearchQ", message);*/
        channel.send(MessageBuilder.withPayload(message).build());
    }


}
