package com.example.issuetraker.service.userService;

import com.example.issuetraker.controller.dto.UserRegistrationDto;
import com.example.issuetraker.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * User Service
 *
 * save - save user
 */
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
