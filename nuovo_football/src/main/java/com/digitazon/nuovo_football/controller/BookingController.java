package com.digitazon.nuovo_football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.nuovo_football.model.Booking;
import com.digitazon.nuovo_football.service.BookingService;

@CrossOrigin // IMPORTANT: to join back-end and front-end
@RestController
@RequestMapping("/booking")
public class BookingController {
    
    @Autowired
    BookingService bookingService;
    
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getall(){
        return new ResponseEntity<>(bookingService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return new ResponseEntity<>(bookingService.saveBooking(booking), HttpStatus.CREATED); 
    }

    @PutMapping("/update")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking, @RequestParam Long id){
        return new ResponseEntity<>(bookingService.updateBooking(booking, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBooking(@RequestParam Long id){
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Booking deleted", HttpStatus.OK);
    }
}
