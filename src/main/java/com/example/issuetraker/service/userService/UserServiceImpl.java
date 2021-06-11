package com.example.issuetraker.service.userService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import com.example.issuetraker.controller.dto.UserRegistrationDto;
import com.example.issuetraker.model.Role;
import com.example.issuetraker.model.User;
import com.example.issuetraker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     * Create user repository
     */
    private UserRepository userRepository;

    /**
     * Auto-create a password encoder
     */
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * User repository creation constructor
     * @param userRepository - user repository
     */
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    /**
     * Saving a user to a database
     *
     * User object creation, data retrieval, password coding
     *
     * @param registrationDto - user data
     * @return - current user
     */
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFullName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    /**
     * User identification, search for a user by email in the database
     * @param username - user email
     * @return Current user
     * @throws UsernameNotFoundException - checking for the correctness of the entered data
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    /**
     * Getting roles for a user
     * @param roles - List of roles
     * @return - List of roles
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}