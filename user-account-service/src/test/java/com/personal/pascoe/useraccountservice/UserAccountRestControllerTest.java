package com.personal.pascoe.useraccountservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.personal.pascoe.useraccountservice.controller.UserAccountRestController;
import com.personal.pascoe.useraccountservice.entity.UserAccount;
import com.personal.pascoe.useraccountservice.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserAccountRestControllerTest {

  @Mock UserAccountService userAccountService = mock(UserAccountService.class);
  @InjectMocks UserAccountRestController userAccountRestController;

  @Test
  public void getUserAccount() {
    UserAccount userAccount = mockUserAccountOf();
    when(userAccountService.getUserAccountById(anyLong())).thenReturn(userAccount);
    assertEquals(
        userAccount.getName(), userAccountRestController.getUserAccount(1l).getBody().getName());
  }

  @Test
  public void addUserAccount() {
    UserAccount userAccount = mockUserAccountOf();
    when(userAccountService.addUserAccount(userAccount)).thenReturn(userAccount);
    assertEquals(
        userAccount.getName(),
        userAccountRestController.createUserAccount(userAccount).getBody().getName());
  }

  @Test
  public void deleteUserAccount() {
    when(userAccountService.deleteUserAccount(anyLong())).thenReturn(1l);
    assertEquals(1l, userAccountRestController.deleteUserAccount(1l).getBody());
  }

  private UserAccount mockUserAccountOf() {
    UserAccount userAccount = mock(UserAccount.class);
    when(userAccount.getName()).thenReturn("John");
    return userAccount;
  }
}
