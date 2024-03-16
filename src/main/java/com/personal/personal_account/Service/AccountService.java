package com.personal.personal_account.Service;

import com.personal.personal_account.Model.User;
import com.personal.personal_account.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
@Log4j
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    public User getUserInfo(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }

}
