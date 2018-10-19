package com.personal.pascoe.flightsservice.entity;

import com.personal.pascoe.flightsservice.model.Airport;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    @Id
    @GeneratedValue
    private Long flightNumber;
    private Airport departureAirport;
    private Airport destincationAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int passengerCount;

    public Flight(Long flightNumber, Airport departureAirport, Airport destinationAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.destincationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        System.out.println("Hllo");
    }

    public Flight(Airport departureAirport, Airport destincationAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.departureAirport = departureAirport;
        this.destincationAirport = destincationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getFlightNumber() {
        return this.flightNumber;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getDestincationAirport() {
        return destincationAirport;
    }

    public void setDestincationAirport(Airport destincationAirport) {
        this.destincationAirport = destincationAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(destincationAirport, flight.destincationAirport) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(arrivalTime, flight.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, destincationAirport, departureTime, arrivalTime);
    }

    public void increasePassengerCount() {
        this.passengerCount++;
    }

    public int getPassengerCount() {
        return this.passengerCount;
    }
}
