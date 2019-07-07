package com.personal.pascoe.flightsservice.controller;

import com.personal.pascoe.flightsservice.client.UserAccountService;
import com.personal.pascoe.flightsservice.entity.Flight;
import com.personal.pascoe.flightsservice.model.Booking;
import com.personal.pascoe.flightsservice.service.FlightsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@AllArgsConstructor
@RestController
@RequestMapping("/flights")
public class FlightsRestController {

  private FlightsService flightsService;
  private UserAccountService userAccountService;

  @GetMapping
  public List<Flight> getFlights() {
    return flightsService.getAllFlights();
  }

  @GetMapping("/{flightNumber}")
  public ResponseEntity<Flight> getFlightByFlightNumber(@PathVariable long flightNumber) {
    Flight flight = flightsService.getFlightByFlightNumber(flightNumber);
    flight.add(linkTo(methodOn(Flight.class).getFlightNumber()).withSelfRel());

    return new ResponseEntity(flight, HttpStatus.OK);
  }

  @PutMapping("/{flightNumber}")
  public ResponseEntity<String> addPassengerToFlight(
      @PathVariable long flightNumber, @RequestBody Long userAccountId) {
    flightsService.addPassengerToFlight(flightNumber, userAccountId);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/addFlight")
  public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
    Flight createdFlight = flightsService.addFlight(flight);
    flight.add(linkTo(methodOn(Flight.class).getFlightNumber()).withSelfRel());

    return new ResponseEntity(createdFlight, HttpStatus.CREATED);
  }

  @GetMapping("/users/{userId}")
  public ResponseEntity<List<Flight>> getFlightsForUser(
      @PathVariable(value = "userId") Long userId) {
    List<Booking> bookingList = userAccountService.getUserAccount(userId).getBookingList();

    List<Flight> flights =
        bookingList
            .stream()
            .map(booking -> flightsService.getFlightByFlightNumber(booking.getFlightNumber()))
            .collect(Collectors.toList());

    return new ResponseEntity(flights, HttpStatus.OK);
  }
}
