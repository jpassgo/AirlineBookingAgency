package com.personal.pascoe.flightsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Passenger {

    private String name;
    private String dob;
    private String seatNumber;
}
