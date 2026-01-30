package com.mmendoza.internal_system_for_club.domain.model;

import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Boolean isActive;
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String email, String password, Set<Role>roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.roles = roles;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = true;
    }

    public User(String username, String email, String password, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = true;
        this.roles = roles;
    }

    public static User create(String username, String email, String hashedPassword, Set<Role> roles) {
        return new User(username, email, hashedPassword, roles);
    }

}
