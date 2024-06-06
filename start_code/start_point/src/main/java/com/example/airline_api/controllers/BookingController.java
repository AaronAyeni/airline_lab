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
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<List<Booking>> getBookingsByPassengerId(@PathVariable Long passengerId) {
        List<Booking> bookings = bookingService.getBookingsByPassengerId(passengerId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<List<Booking>> getBookingsByFlightId(@PathVariable Long flightId) {
        List<Booking> bookings = bookingService.getBookingsByFlightId(flightId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }



    @PostMapping(value = "/{id}")
    public ResponseEntity<Booking> addNewBooking(@RequestParam Long passengerId, @RequestParam Long flightId,
                                                 @RequestParam int seatNumber, @RequestParam String mealPreference){
        Booking booking = bookingService.bookFlight(passengerId, flightId, seatNumber, mealPreference);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}/meal-preference")
    public ResponseEntity<Booking> updateMealPreference(@PathVariable Long id, @RequestParam String mealPreference) {
        Booking updatedBooking = bookingService.updateMealPreference(id, mealPreference);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }
}
