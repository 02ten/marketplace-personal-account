package com.personal.personal_account.Repository;

import com.personal.personal_account.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
