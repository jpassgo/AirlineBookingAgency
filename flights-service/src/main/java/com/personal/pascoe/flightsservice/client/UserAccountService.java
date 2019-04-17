package com.personal.pascoe.flightsservice.client;

import com.personal.pascoe.flightsservice.model.UserAccount;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAccountService {
  UserAccountFeignClient userAccountFeignClient;

  public UserAccount getUserAccount(long userAccountId) {
    return userAccountFeignClient.getUserAccount(userAccountId);
  }
}