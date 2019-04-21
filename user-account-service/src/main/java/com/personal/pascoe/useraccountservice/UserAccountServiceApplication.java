package com.personal.pascoe.useraccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserAccountServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserAccountServiceApplication.class, args);
  }
}
