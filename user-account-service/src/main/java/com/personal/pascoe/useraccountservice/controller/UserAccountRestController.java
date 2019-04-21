package com.personal.pascoe.useraccountservice.controller;

import com.personal.pascoe.useraccountservice.entity.UserAccount;
import com.personal.pascoe.useraccountservice.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserAccountRestController {

  UserAccountService userAccountService;

  @GetMapping("/{userAccountId}")
  public ResponseEntity<UserAccount> getUserAccount(@PathVariable long userAccountId) {
    return new ResponseEntity(userAccountService.getUserAccountById(userAccountId), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
    return new ResponseEntity(userAccountService.addUserAccount(userAccount), HttpStatus.CREATED);
  }

  @DeleteMapping("/{userAccountId}")
  public ResponseEntity<UserAccount> deleteUserAccount(@PathVariable long userAccountId) {
    return new ResponseEntity(userAccountService.deleteUserAccount(userAccountId), HttpStatus.OK);
  }
}
