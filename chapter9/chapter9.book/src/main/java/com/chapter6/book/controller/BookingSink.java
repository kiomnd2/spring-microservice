package com.chapter6.book.controller;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

interface BookingSink {
    public static String CHECKINQ ="checkInQ";

    @Input("checkInQ")
    public MessageChannel checkInQ();
}
