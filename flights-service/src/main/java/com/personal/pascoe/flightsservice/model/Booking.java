package com.personal.pascoe.flightsservice.model;

import java.time.LocalDateTime;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;

@Entity
public class Booking {

  @Id private long id;

  @Embedded
  @AttributeOverride(name = "name", column = @Column(name = "departure_airport"))
  private Airport departureAirport;

  @AttributeOverride(name = "name", column = @Column(name = "destination_airport"))
  private Airport destinationAirport;

  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;
}
