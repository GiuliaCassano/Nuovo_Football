package com.digitazon.nuovo_football.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.nuovo_football.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long>{
    
}
