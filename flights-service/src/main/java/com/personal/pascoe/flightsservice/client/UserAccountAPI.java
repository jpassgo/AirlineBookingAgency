package com.personal.pascoe.flightsservice.client;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserAccountAPI {
    UserAccountFeignClient userAccountFeignClient;

    public UserAccount getUserAccount(long userAccount) {
        return userAccountFeignClient.getUserAccount(userAccount);
    }
}
