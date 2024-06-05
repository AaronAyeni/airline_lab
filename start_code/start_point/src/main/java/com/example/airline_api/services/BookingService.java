package com.example.airline_api.services;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private FlightRepository flightRepository;

    public Booking bookFlight(Long passengerId, Long flightId, int seatNumber, String mealPreference) {
        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow();
        Flight flight = flightRepository.findById(flightId).orElseThrow();

        Booking booking = new Booking();
        booking.setPassenger(passenger);
        booking.setFlight(flight);
        booking.setSeatNumber(seatNumber);
        booking.setMealPreference(mealPreference);

        return bookingRepository.save(booking);
    }
}
