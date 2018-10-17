package com.personal.pascoe.flightsservice.dao;

import com.personal.pascoe.flightsservice.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findAll();
}
