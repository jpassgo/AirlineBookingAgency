package com.personal.pascoe.flightsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FlightsServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(FlightsServiceApplication.class, args);
  }
}
