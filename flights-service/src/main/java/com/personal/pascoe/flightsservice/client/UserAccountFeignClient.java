package com.personal.pascoe.flightsservice.client;

import com.personal.pascoe.flightsservice.model.UserAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("userAccounts")
public interface UserAccountFeignClient {

  @RequestMapping(method = RequestMethod.GET, value = "/useraccounts/{userAccountId}")
  UserAccount getUserAccount(@Param("userAccountId") long userAccountId);
}
