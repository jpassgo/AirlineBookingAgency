package com.personal.pascoe.flightsservice.controller;

import com.personal.pascoe.flightsservice.entity.Flight;
import com.personal.pascoe.flightsservice.model.Passenger;
import com.personal.pascoe.flightsservice.service.FlightsService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PutMapping("/flights/{flightNumber}")
  public ResponseEntity<String> addPassengerToFlight(
      @PathVariable Long flightNumber, @RequestBody Passenger passenger) {
    ResponseEntity<String> response =
        new ResponseEntity<>(
            flightsService.addPassenegerToManifest(flightNumber, passenger).toString(),
            HttpStatus.OK);
    return response;
  }

  @PostMapping("/flights")
  public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
    flightsService.addFlight(flight);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
