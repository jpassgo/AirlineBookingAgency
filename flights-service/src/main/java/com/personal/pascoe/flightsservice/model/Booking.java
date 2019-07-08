package com.personal.pascoe.flightsservice.model;

import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Booking {

  @Embedded
  @AttributeOverride(name = "name", column = @Column(name = "departure_airport"))
  private Airport departureAirport;

  @AttributeOverride(name = "name", column = @Column(name = "destination_airport"))
  private Airport destinationAirport;

  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;

  private long flightNumber;
  private int seatNumber;
}
