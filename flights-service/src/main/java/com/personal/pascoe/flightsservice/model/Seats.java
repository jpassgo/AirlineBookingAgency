package com.personal.pascoe.flightsservice.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seats {
  private Map<String, Boolean> seatMap;
}
