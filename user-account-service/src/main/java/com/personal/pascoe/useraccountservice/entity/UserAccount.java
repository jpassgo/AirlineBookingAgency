package com.personal.pascoe.useraccountservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@JsonAppend
public class UserAccount {

    @Id @GeneratedValue
    Long id;
    String name;
}
