package com.example.issuetraker.controller;


import com.example.issuetraker.controller.dto.UserRegistrationDto;
import com.example.issuetraker.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for user authentication
 */

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    /**
     * Creating a user service object
     */
    private UserService userService;

    /**
     * Creating a user service to manage it
     * @param userService - user service
     */
    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creating a user attribute to pass the model
     * @return empty object for subsequent filling of user data
     */
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    /**
     * Getting the registration form
     * @return - registration page
     */
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    /**
     * User registration
     * @param userRegistrationDto - retrieving user data
     * @return - check for successful registration
     *              without going to another page
     */
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }
}
