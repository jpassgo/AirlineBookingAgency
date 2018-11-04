package com.personal.pascoe.useraccountservice;

import com.personal.pascoe.useraccountservice.controller.UserAccountRestController;
import com.personal.pascoe.useraccountservice.entity.UserAccount;
import com.personal.pascoe.useraccountservice.service.UserAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserAccountRestControllerTest {

    @Mock
    UserAccountService userAccountService = mock(UserAccountService.class);
    @InjectMocks
    UserAccountRestController userAccountRestController;

    @Test
    public void getUserAccount() {
        UserAccount userAccount = new UserAccount(
                new Long(1),
                "john",
                LocalDate.of(1995, 04, 9),
                "Jeff@jeff.com",
                "501 street addr",
                "Chicago",
                "Illinois",
                "60069");

        when(userAccountService.getUserAccountById(anyLong())).thenReturn(userAccount);
        assertEquals(
                userAccount.getName(),
                userAccountRestController.getUserAccount(new Long(1))
                        .getBody()
                        .getName());
    }



}
