package com.chapter6.checkin.component;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CheckInSource {
    public static String CHECKINQ="checkInQ";
    @Output("checkInQ")
    public MessageChannel checkInQ();
}
