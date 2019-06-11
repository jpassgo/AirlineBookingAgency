package com.personal.pascoe.flightsservice.service;

import com.personal.pascoe.flightsservice.dao.FlightRepository;
import com.personal.pascoe.flightsservice.entity.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightsServiceTest {

    @Mock Flight mockFlight;

    @Mock private FlightRepository flightRepository;

    @InjectMocks
    private FlightsService flightsService;

    @Test
    void getAllFlights() {
        when(flightRepository.findAll()).thenReturn(Collections.singletonList(mockFlight));
        assertThat(flightsService.getAllFlights()).isNotEmpty();
    }

    @Test
    void getFlightByFlightNumber() {
        when(flightRepository.findById(any())).thenReturn(Optional.of(mockFlight));

        Flight flight = flightsService.getFlightByFlightNumber(1L);

        assertThat(flight).isNotNull();
    }

    @Test
    void addPassengerToFlight() {
        when(flightRepository.findById(any())).thenReturn(Optional.of(mockFlight));
        when(flightRepository.save(any())).thenReturn(mockFlight);

        flightsService.addPassengerToFlight(4L, 4L);
    }

    @Test
    void addFlight() {
        when(flightRepository.save(any())).thenReturn(mockFlight);
        
        Flight flight = Flight.builder()
                .flightNumber(1L)
                .arrivalTime(LocalDateTime.now())
                .departureTime(LocalDateTime.now())
                .build();

        assertThat(flightsService.addFlight(flight)).isNotNull();
    }
}