package com.personal.personal_account;

import com.personal.personal_account.Model.Role;
import com.personal.personal_account.Model.User;
import com.personal.personal_account.Repository.UserRepository;
import com.personal.personal_account.Service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class PersonalAccountApplicationTests {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private AccountService accountService;

    @Test
    void getPersonalData_ValidData_ReturnsUser() {
        Long id = 1L;
        Set<Role> roles = Set.of(new Role("USER"));
        Mockito.when(userRepository.findById(id)).thenReturn(Optional.of(new User(1L, "02ten", "12345", "Alexander", "Ten",
                roles)));

        User user = accountService.getUserInfo(id);
        Assertions.assertTrue(new ReflectionEquals(new User(id, "02ten", null, "Alexander", "Ten",
                roles)).matches(user));
    }
}