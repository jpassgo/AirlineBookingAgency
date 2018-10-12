package com.personal.pascoe.flightsservice.controller;

import com.personal.pascoe.flightsservice.entity.Flight;
import com.personal.pascoe.flightsservice.model.Airport;
import com.personal.pascoe.flightsservice.service.FlightsService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class FlightsRestController {

    private FlightsService flightsService;

    public FlightsRestController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    public List<Flight> getFlights() {

       /* return Arrays.asList(
                new Flight(new Airport("ohare"), new Airport("LAX"),
                        LocalDateTime.of(2018, 10, 01, 3, 45),
                        LocalDateTime.of(2018, 10, 01, 6, 45)),
                new Flight(new Airport("Lax"), new Airport("Ohare"),
                        LocalDateTime.of(2018, 10, 01, 3, 45),
                        LocalDateTime.of(2018, 10, 01, 6, 45)));*/
       return flightsService.getAllFlights();
    }
}
