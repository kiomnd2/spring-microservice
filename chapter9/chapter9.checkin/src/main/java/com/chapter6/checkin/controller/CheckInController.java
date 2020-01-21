package com.chapter6.checkin.controller;

import com.chapter6.checkin.component.CheckInComponent;
import com.chapter6.checkin.entity.CheckInRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

    CheckInComponent checkInComponent;

    @Autowired
    CheckInController(CheckInComponent checkInComponent)
    {
        this.checkInComponent = checkInComponent;
    }

    @RequestMapping("/get/{id}")
    CheckInRecord getCheckIn(@PathVariable long id)
    {
        return checkInComponent.getCheckInRecord(id);
    }

    @RequestMapping(value ="/create", method = RequestMethod.POST)
    long checkIn(@RequestBody CheckInRecord checkIn)
    {
        return checkInComponent.checkIn(checkIn);
    }

}
