package com.personal.pascoe.flightsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAppend
public class UserAccount {

  @Id @GeneratedValue @JsonIgnore Long id;
  String name;
  LocalDate dob;
  String emailAddress;
  String streetAddress;
  String city;
  String state;
  String zipcode;
}
