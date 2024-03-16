package com.personal.personal_account.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    @ManyToMany
    private Set<Role> roles;
}
