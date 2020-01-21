package com.chapter6.book.controller;

import com.chapter6.book.component.BookingComponent;
import com.chapter6.book.component.BookingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@EnableBinding(BookingSink.class)
@Component
public class Receiver {
    @Autowired
    BookingComponent bookingComponent;

    public Receiver(){

    }

/*
    @RabbitListener(queues = "CheckINQ")
    public void processMessage(long bookingID ) {

        System.out.println(bookingID);

        bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
    }*/
    @ServiceActivator(inputChannel = BookingSink.CHECKINQ)
    public void accept(long bookingID) {
        bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingID);
    }


}
