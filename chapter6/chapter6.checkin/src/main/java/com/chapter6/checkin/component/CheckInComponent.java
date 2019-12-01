package com.chapter6.checkin.component;

import com.chapter6.checkin.entity.CheckInRecord;
import com.chapter6.checkin.repository.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CheckInComponent {
    private static final Logger logger = LoggerFactory.getLogger(CheckInComponent.class);


    CheckinRepository checkinRepository;
    Sender sender;

    @Autowired
    CheckInComponent(CheckinRepository checkinRepository ,Sender sender )
    {
        this.checkinRepository = checkinRepository;
        this.sender = sender;
    }

    public long checkIn(CheckInRecord checkIn)
    {
        checkIn.setCheckInTime(new Date());
        logger.info("Saving checkin ");
        //save
        long id = checkinRepository.save(checkIn).getId();
        logger.info("Successfully saved checkin ");
        //send a message back to booking to update status
        logger.info("Sending booking id "+ id);
        sender.send(id);
        return id;
    }

    public CheckInRecord getCheckInRecord(long id)
    {
        return checkinRepository.findById(id).get();
    }



}
