package com.personal.pascoe.useraccountservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@JsonAppend
public class UserAccount {

    @Id @GeneratedValue
    Long id;
    String name;
    LocalDate dob;
    String emailAddress;
    String streetAddress;
    String city;
    String state;
    String zipcode;
}
