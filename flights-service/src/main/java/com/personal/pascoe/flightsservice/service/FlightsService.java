package com.personal.pascoe.flightsservice.service;

import com.personal.pascoe.flightsservice.dao.FlightRepository;
import com.personal.pascoe.flightsservice.entity.Flight;
import com.personal.pascoe.flightsservice.model.Passenger;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FlightsService {

  private FlightRepository flightRepository;

  public List<Flight> getAllFlights() {
    return flightRepository.findAll();
  }

  public Flight getFlightByFlightNumber(Long flightNumber) {
    return flightRepository.findById(flightNumber).isPresent()
        ? flightRepository.findById(flightNumber).get()
        : null;
  }

  public Integer addPassenegerToManifest(Long flightNumber, Passenger passenger) {
    Flight flight = getFlightByFlightNumber(flightNumber);
    flight.increasePassengerCount();
    flightRepository.save(flight);
    return flight.getPassengerCount();
  }

  public void addFlight(Flight flight) {
    flightRepository.save(flight);
  }
}
