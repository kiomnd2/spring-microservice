package com.chapter6.book.repository;

import com.chapter6.book.entitiy.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingRecord, Long> {

}
