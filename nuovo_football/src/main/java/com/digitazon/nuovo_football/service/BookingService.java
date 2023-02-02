package com.digitazon.nuovo_football.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.nuovo_football.model.Booking;
import com.digitazon.nuovo_football.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    PitchService pitchService;

    @Autowired
    UserService userService;
    
    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking){
        if(booking.getPitch() != null){
            pitchService.savePitch(booking.getPitch());
        }

        if(booking.getUser() != null){
            userService.saveUser(booking.getUser());
        }

        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking newBooking, Long id){
       Optional<Booking> oldBookingOpt = bookingRepository.findById(id);  //Questo optional per accettare un possibile null come risultato
        if(oldBookingOpt != null){ //Forse .isPresent
            Booking oldBooking = oldBookingOpt.get();
            oldBooking.setDay(newBooking.getDay());
            oldBooking.setHour(newBooking.getHour());
            oldBooking.setPitch(newBooking.getPitch());
            oldBooking.setUser(newBooking.getUser());

            return bookingRepository.save(oldBooking);
        }
        
        return null;
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }
}
