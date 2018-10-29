package com.personal.pascoe.useraccountservice.controller;

import com.personal.pascoe.useraccountservice.entity.UserAccount;
import com.personal.pascoe.useraccountservice.service.UserAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserAccountRestController {

    UserAccountService userAccountService;

    @GetMapping("/useraccounts/{userAccountId}")
    public ResponseEntity<UserAccount> getUserAccount(@PathVariable Long userAccountId) {
        return new ResponseEntity(
                userAccountService.getUserAccountById(userAccountId),
                HttpStatus.OK);
    }
}
