package com.personal.pascoe.useraccountservice.service;

import com.personal.pascoe.useraccountservice.dao.UserAccountRepository;
import com.personal.pascoe.useraccountservice.entity.UserAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTest {

  @Mock UserAccountRepository userAccountRepository;

  @InjectMocks UserAccountService userAccountService;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  UserAccount userAccount;

  @Test
  public void getUserAccountById() {
    when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(userAccount));
    assertThat(userAccountService.getUserAccountById(1l)).isEqualTo(userAccount);
  }

  @Test
  public void addUserAccount() {
    when(userAccountRepository.save(any())).thenReturn(userAccount);
    assertThat(userAccountService.addUserAccount(userAccount)).isEqualTo(userAccount);
  }

  @Test
  public void deleteUserAccount() {
    when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(userAccount));
    when(userAccount.getId()).thenReturn(1l);

    doNothing().when(userAccountRepository).delete(any());

    assertThat(userAccountService.deleteUserAccount(1l)).isEqualTo(1l);
  }
}
