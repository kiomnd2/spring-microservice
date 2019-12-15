package com.chapter6.book.repository;

import com.chapter6.book.entitiy.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Inventory findByFlightNumberAndFlightDate(String flightNumgber, String flightDate );

}
