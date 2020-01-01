package com.chapter6.book.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookingSource {
    public static String InventoryQ="inventoryQ";

    @Output("inventoryQ")
    MessageChannel inventoryQ();

}
