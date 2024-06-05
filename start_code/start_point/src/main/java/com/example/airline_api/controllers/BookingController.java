package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return null;
    }

    // TODO: Add details of a new booking
    @PostMapping(value = "/{id}")
    public ResponseEntity<Booking> addNewBooking(@RequestParam Long passengerId, @RequestParam Long flightId,
                                                 @RequestParam int seatNumber, @RequestParam String mealPreference){
        Booking booking = bookingService.bookFlight(passengerId, flightId, seatNumber, mealPreference);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    // TODO: Extension - Update passenger meal preference
    @PatchMapping
    public ResponseEntity<Booking> updateMealPreference(){
        return null;
    }

}
