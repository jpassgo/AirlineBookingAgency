package com.personal.pascoe.flightsservice.controller;

import com.personal.pascoe.flightsservice.entity.Flight;
import com.personal.pascoe.flightsservice.model.Passenger;
import com.personal.pascoe.flightsservice.service.FlightsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class FlightsRestController {

    private FlightsService flightsService;

    @GetMapping("/flights")
    public List<Flight> getFlights() {
       return flightsService.getAllFlights();
    }

    @GetMapping("/flights/{flightNumber}")
    public Flight getFlightByFlightNumber(@PathVariable Long flightNumber) {
        return flightsService.getFlightByFlightNumber(flightNumber);
    }

    @PostMapping("/flights/{flightNumber}")
    public String addPassengerToFlight(@PathVariable Long flightNumber, @RequestBody Passenger passenger) {
        return flightsService.addPassenegerToManifest(flightNumber, passenger).toString();
    }
}
