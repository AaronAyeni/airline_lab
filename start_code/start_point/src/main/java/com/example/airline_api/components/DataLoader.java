package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Passenger passenger1 = new Passenger();
        passenger1.setName("John Doe");
        passenger1.setEmail("john@example.com");
        passengerRepository.save(passenger1);

        Passenger passenger2 = new Passenger();
        passenger2.setName("Jane Smith");
        passenger2.setEmail("jane@example.com");
        passengerRepository.save(passenger2);

        Flight flight1 = new Flight();
        flight1.setDestination("New York");
        flight1.setCapacity(200);
        flight1.setDepartureDate(LocalDate.of(2023, 12, 25));
        flight1.setDepartureTime(LocalTime.of(15, 30));
        flightRepository.save(flight1);

        Flight flight2 = new Flight();
        flight2.setDestination("London");
        flight2.setCapacity(150);
        flight2.setDepartureDate(LocalDate.of(2023, 12, 26));
        flight2.setDepartureTime(LocalTime.of(16, 45));
        flightRepository.save(flight2);
    }
}
