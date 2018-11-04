package com.personal.pascoe.flightsservice.dao;

import com.personal.pascoe.flightsservice.entity.Flight;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
  List<Flight> findAll();
}
