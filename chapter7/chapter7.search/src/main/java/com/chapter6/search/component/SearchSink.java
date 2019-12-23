package com.chapter6.search.component;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

interface SearchSink {
    public static String INVENTORYQ="inventoryQ";

    @Input("inventoryQ")
    public MessageChannel inventoryQ();

}
