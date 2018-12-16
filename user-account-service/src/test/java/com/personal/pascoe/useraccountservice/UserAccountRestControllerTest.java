package com.personal.pascoe.useraccountservice;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.personal.pascoe.useraccountservice.controller.UserAccountRestController;
import com.personal.pascoe.useraccountservice.entity.UserAccount;
import com.personal.pascoe.useraccountservice.service.UserAccountService;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserAccountRestControllerTest {

    @Mock
    UserAccountService userAccountService = mock(UserAccountService.class);
    @InjectMocks
    UserAccountRestController userAccountRestController;
    UserAccount userAccount;

    @Before
    public void setUp() throws Exception {
        userAccount =
                new UserAccount(
                        new Long(1),
                        "john",
                        LocalDate.of(1995, 04, 9),
                        "Jeff@jeff.com",
                        "501 street addr",
                        "Chicago",
                        "Illinois",
                        "60069");
    }

    @Test
    public void testGetUserAccount() {
        when(userAccountService.getUserAccountById(anyLong())).thenReturn(userAccount);
        assertEquals(
                userAccount.getName(),
                userAccountRestController.getUserAccount(new Long(1)).getBody().getName());
    }

    @Test
    public void testAddUserAccount() {
        when(userAccountService.addUserAccount(userAccount)).thenReturn(userAccount);
        assertEquals(userAccount, userAccountRestController.putUserAccount(userAccount));
    }
}
