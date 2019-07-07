package com.personal.pascoe.flightsservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.personal.pascoe.flightsservice.dao.FlightRepository;
import com.personal.pascoe.flightsservice.entity.Flight;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlightsServiceTest {

  @Mock private FlightRepository flightRepository;

  @InjectMocks private FlightsService flightsService;

  @Test
  void getAllFlights() {
    Flight flight = mock(Flight.class);
    when(flight.getFlightNumber()).thenReturn(1L);

    when(flightRepository.findAll()).thenReturn(Arrays.asList(flight));

    assertThat(flightsService.getAllFlights().get(0).getFlightNumber())
        .isEqualTo(flight.getFlightNumber());
  }

  @Test
  void getFlightByFlightNumber() {
    Flight flight = mock(Flight.class);
    when(flight.getFlightNumber()).thenReturn(1L);

    when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flight));

    assertThat(flightsService.getFlightByFlightNumber(1L).getFlightNumber())
        .isEqualTo(flight.getFlightNumber());
  }

  @Test
  void addPassengerToFlight() {
    Flight flight = mock(Flight.class);
    when(flight.getFlightNumber()).thenReturn(1L);

    when(flightRepository.findById(anyLong())).thenReturn(Optional.of(flight));

    when(flightRepository.save(any(Flight.class))).thenReturn(flight);

    Flight updatedFlight = flightsService.addPassengerToFlight(Long.valueOf(1), Long.valueOf(1));

    assertThat(updatedFlight.getFlightNumber()).isEqualTo(1L);
  }

  @Test
  void addFlight() {}
}
