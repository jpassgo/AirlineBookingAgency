package com.personal.pascoe.flightsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Airport {
    private String name;
}
