package com.personal.pascoe.flightsservice.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.personal.pascoe.flightsservice.model.Airport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Flight extends ResourceSupport {

  @Id @GeneratedValue private Long flightNumber;

  @Embedded
  @AttributeOverride(name = "name", column = @Column(name = "departure_airport"))
  private Airport departureAirport;

  @AttributeOverride(name = "name", column = @Column(name = "destination_airport"))
  private Airport destinationAirport;

  private LocalDateTime departureTime;
  private LocalDateTime arrivalTime;

  @ElementCollection(targetClass = Long.class)
  private List<Long> passengers;

  @JsonCreator
  public Flight(
      long flightNumber,
      Airport departureAirport,
      Airport destinationAirport,
      LocalDateTime departureTime,
      LocalDateTime arrivalTime,
      List<Long> passengers) {
    this.flightNumber = flightNumber;
    this.departureAirport = departureAirport;
    this.destinationAirport = destinationAirport;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.passengers = passengers;
  }

  public void addPassenger(Long userAccountId) {
    this.passengers.add(userAccountId);
  }

  public int getPassengerCount() {
    return this.passengers.size();
  }
}
