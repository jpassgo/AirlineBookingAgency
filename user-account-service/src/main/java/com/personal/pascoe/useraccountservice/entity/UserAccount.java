package com.personal.pascoe.useraccountservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAppend
public class UserAccount {

  @Id @GeneratedValue @JsonIgnore long id;
  String name;
  LocalDate dob;
  String emailAddress;
  String streetAddress;
  String city;
  String state;
  String zipcode;
}
