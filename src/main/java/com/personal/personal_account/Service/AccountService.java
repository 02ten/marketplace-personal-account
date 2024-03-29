package com.personal.personal_account.Service;

import com.personal.personal_account.Model.User;
import com.personal.personal_account.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j
@RequiredArgsConstructor
@Service
public class AccountService {
    private final UserRepository userRepository;
    public User getUserInfo(Long id){
        log.info("User getting personal info");
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            log.error("User not found");
            throw new RuntimeException("User not found");
        }
        log.info("Successful getting info");
        User user = optionalUser.get();
        user.setPassword(null);
        return user;
    }

}
