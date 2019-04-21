package com.personal.pascoe.flightsservice.service;

import com.personal.pascoe.flightsservice.dao.FlightRepository;
import com.personal.pascoe.flightsservice.entity.Flight;
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

  // TODO: Return something useful from this method
  public void addPassengerToFlight(Long flightNumber, Long userAccountId) {
    Flight flight = getFlightByFlightNumber(flightNumber);
    flight.addPassenger(userAccountId);
    flightRepository.save(flight);
  }

  public Flight addFlight(Flight flight) {
    return flightRepository.save(flight);
  }
}
