package com.personal.personal_account.Controller;

import com.personal.personal_account.Model.User;
import com.personal.personal_account.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal")
@RequiredArgsConstructor
public class PersonalAccountController {
    private final AccountService accountService;
    @GetMapping("/account/{id}")
    public User getPersonalData(@PathVariable Long id){
        User user = accountService.getUserInfo(id);
        return user;
    }
}
