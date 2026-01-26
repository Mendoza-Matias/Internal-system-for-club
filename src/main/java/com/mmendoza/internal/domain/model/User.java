package com.mmendoza.internal.domain.model;

public class User {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private Boolean isActive;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = true;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static User create(String username, String email, String hashedPassword) {
        return new User(username, email, hashedPassword);
    }

}
