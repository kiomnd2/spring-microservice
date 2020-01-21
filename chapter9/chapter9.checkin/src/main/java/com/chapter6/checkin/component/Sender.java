package com.chapter6.checkin.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CheckInSource.class)
public class Sender {

    RabbitMessagingTemplate template;

    @Output(CheckInSource.CHECKINQ)
    @Autowired
    private MessageChannel messageChannel;

/*

    @Autowired
    Sender(RabbitMessagingTemplate template)
    {
        this.template = template;
    }

    @Bean
    Queue queue()
    {
        return new Queue("CheckINQ", false);
    }
*/


    public void send(Object message)
    {
        messageChannel.send(MessageBuilder.withPayload(message).build());
//        template.convertAndSend("CheckINQ", message);
    }


}
