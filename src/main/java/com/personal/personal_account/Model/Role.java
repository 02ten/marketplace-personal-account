package com.personal.personal_account.Model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Getter
public class Role {
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
}
