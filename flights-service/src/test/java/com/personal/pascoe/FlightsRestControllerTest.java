package com.personal.pascoe;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.personal.pascoe.flightsservice.controller.FlightsRestController;
import com.personal.pascoe.flightsservice.entity.Flight;
import com.personal.pascoe.flightsservice.model.Airport;
import com.personal.pascoe.flightsservice.model.Passenger;
import com.personal.pascoe.flightsservice.service.FlightsService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FlightsRestControllerTest {

  @Mock FlightsService mockFlightsService = mock(FlightsService.class);
  FlightsRestController flightsRestController = new FlightsRestController(mockFlightsService);

  @Test
  public void getFlights_returnsListOfFlights() {
    List<Flight> flights =
        Arrays.asList(
            new Flight(
                1L,
                new Airport("ohare"),
                new Airport("LAX"),
                LocalDateTime.of(2018, 10, 01, 3, 45),
                LocalDateTime.of(2018, 10, 01, 6, 45)),
            new Flight(
                1L,
                new Airport("Lax"),
                new Airport("Ohare"),
                LocalDateTime.of(2018, 10, 01, 3, 45),
                LocalDateTime.of(2018, 10, 01, 6, 45)));
    when(mockFlightsService.getAllFlights()).thenReturn(flights);
    flightsRestController = new FlightsRestController(mockFlightsService);
    assertTrue(flights.get(0).equals(flightsRestController.getFlights().get(0)));
  }

  @Test
  public void getFlightByFlightNumber_returnFlight() {
    Flight flight =
        new Flight(
            1L,
            new Airport("ohare"),
            new Airport("LAX"),
            LocalDateTime.of(2018, 10, 1, 2, 10),
            LocalDateTime.of(2018, 10, 1, 5, 12));
    when(flightsRestController.getFlightByFlightNumber(1L)).thenReturn(flight);
    assert (flight.getFlightNumber())
        .equals(flightsRestController.getFlightByFlightNumber(1L).getFlightNumber());
  }

  @Test
  public void addPassengerToManifest() {
    Flight flight =
        new Flight(
            1L,
            new Airport("ohare"),
            new Airport("LAX"),
            LocalDateTime.of(2018, 10, 1, 2, 10),
            LocalDateTime.of(2018, 10, 1, 5, 12));

    assertTrue(
        flightsRestController
            .addPassengerToFlight(1L, new Passenger("John", LocalDate.now(), "B2"))
            .getStatusCode()
            .is2xxSuccessful());
  }

  @Test
  public void addFlight() {
    Flight flight =
        new Flight(
            1L,
            new Airport("ohare"),
            new Airport("LAX"),
            LocalDateTime.of(2018, 10, 1, 2, 10),
            LocalDateTime.of(2018, 10, 1, 5, 12));

    assertTrue(flightsRestController.addFlight(flight).getStatusCode().is2xxSuccessful());
  }
}
