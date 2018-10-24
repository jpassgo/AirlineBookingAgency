package com.personal.pascoe.flightsservice.entity;

import com.personal.pascoe.flightsservice.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private Long flightNumber;
    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "departure_airport"))
    private Airport departureAirport;
    @AttributeOverride(name = "name", column = @Column(name = "destination_airport"))
    private Airport destinationAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int passengerCount;

    public Flight(Long flightNumber, Airport departureAirport, Airport destinationAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this(flightNumber, departureAirport, destinationAirport, departureTime, arrivalTime, 0);
    }

    public void increasePassengerCount() {
        this.passengerCount++;
    }

    public int getPassengerCount() {
        return this.passengerCount;
    }
}
