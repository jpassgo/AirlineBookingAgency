package com.personal.pascoe.flightsservice.dao;

import com.personal.pascoe.flightsservice.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findAll();
}
