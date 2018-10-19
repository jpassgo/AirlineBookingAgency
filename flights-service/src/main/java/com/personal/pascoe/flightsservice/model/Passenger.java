package com.personal.pascoe.flightsservice.model;

public class Passenger {

    private String name;
    private String dob;
    private String seatNumber;

    public Passenger(String name, String dob, String seatNumber) {
        this.name = name;
        this.dob = dob;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}
