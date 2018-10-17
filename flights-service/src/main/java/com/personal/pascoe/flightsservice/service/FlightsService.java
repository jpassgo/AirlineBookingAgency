package com.personal.pascoe.flightsservice.service;

import com.personal.pascoe.flightsservice.dao.FlightRepository;
import com.personal.pascoe.flightsservice.entity.Flight;

import java.util.List;

public class FlightsService {

    private FlightRepository flightRepository;

    public FlightsService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightByFlightNumber(long flightNumber) {
        return flightRepository.findById(flightNumber).isPresent() ?
                flightRepository.findById(flightNumber).get() :
                null;
    }
}
