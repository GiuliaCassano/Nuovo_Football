package com.digitazon.nuovo_football;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digitazon.nuovo_football.model.Booking;
import com.digitazon.nuovo_football.model.Pitch;
import com.digitazon.nuovo_football.model.User;
import com.digitazon.nuovo_football.service.BookingService;
import com.digitazon.nuovo_football.service.PitchService;
import com.digitazon.nuovo_football.service.UserService;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    PitchService pitchService;

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @Override
        public void run(String... args) throws Exception {
            //PITCH
            Pitch pitch1 = new Pitch("Rosatese", "Regular", 80, null);
            Pitch pitch2 = new Pitch("Cristo Re", "Regular", 70, null);

            pitchService.savePitch(pitch1);
            pitchService.savePitch(pitch2);

            //USER
            User user1 = new User("Alessandro", "alessandro@gmail.com", 33952077, null);
            User user2 = new User("Giulia", "giulia@gmail.com", 33410760, null);
            User user3 = new User("Nik", "nik@gmail.com", 33922644, null);
            User user4 = new User("Davide", "davide@gmail.com", 33834919, null);

            userService.saveUser(user1);
            userService.saveUser(user2);
            userService.saveUser(user3);
            userService.saveUser(user4);

            //BOOKING
            Booking booking1 = new Booking("2023-01-22", "20:30", pitch1, user3);
            Booking booking2 = new Booking("2023-02-02", "21:00", pitch2, user4);

            bookingService.saveBooking(booking1);
            bookingService.saveBooking(booking2);
        }

}
