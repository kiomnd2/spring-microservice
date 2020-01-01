package com.chapter6.fares.repository;

import com.chapter6.fares.entity.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaresRepository extends JpaRepository<Fare ,Long> {
    Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate );
}
