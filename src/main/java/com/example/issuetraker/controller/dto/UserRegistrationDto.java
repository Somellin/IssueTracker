package com.example.issuetraker.controller.dto;

/**
 * Object of receiving user data
 */

public class UserRegistrationDto {
    private String fullName;
    private String email;
    private String password;

    public UserRegistrationDto() {
    }

    /**
     * Constructor - creates a user information object
     * @param fullName - user full name
     * @param email - user email
     * @param password - user password
     */
    public UserRegistrationDto(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
