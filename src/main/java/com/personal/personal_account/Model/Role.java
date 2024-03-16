package com.personal.personal_account.Model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
public class Role implements GrantedAuthority {
    private String vale;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;


    public Role(String vale) {
        this.vale = vale;
    }

    public Role(){

    }

    @Override
    public String getAuthority() {
        return vale;
    }

}
