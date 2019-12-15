package com.chapter6.checkin.repository;


import com.chapter6.checkin.entity.CheckInRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CheckinRepository extends JpaRepository<CheckInRecord,Long> {

}
