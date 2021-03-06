package com.personal.pascoe.flightsservice.model;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAppend
public class UserAccount {

  Long id;
  String name;
  LocalDate dob;
  String emailAddress;
  String streetAddress;
  String city;
  String state;
  String zipcode;
  List<Booking> bookingList;
}
