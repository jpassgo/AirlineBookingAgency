package com.personal.pascoe.useraccountservice.service;

import com.personal.pascoe.useraccountservice.dao.UserAccountRepository;
import com.personal.pascoe.useraccountservice.entity.UserAccount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAccountService {

  UserAccountRepository userAccountRepository;

  public UserAccount getUserAccountById(long userAccountId) {
    return userAccountRepository.findById(userAccountId).isPresent()
        ? userAccountRepository.findById(userAccountId).get()
        : null;
  }

  public UserAccount addUserAccount(UserAccount userAccount) {
    return userAccountRepository.save(userAccount);
  }

  public long deleteUserAccount(long userAccountId) {
    UserAccount account = getUserAccountById(userAccountId);
    userAccountRepository.delete(account);
    return account.getId();
  }
}
