package com.daniel.jobportal.controller;

import com.daniel.jobportal.entity.User;
import com.daniel.jobportal.entity.UserType;
import com.daniel.jobportal.service.UserService;
import com.daniel.jobportal.service.UserTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserTypeService userTypeService;
    private final UserService userService;


    public UserController(UserTypeService userTypeService, UserService userService) {
        this.userTypeService = userTypeService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        List<UserType> userTypes = userTypeService.getAll();

        model.addAttribute("getAllTypes", userTypes);
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register/new")
    public String userRegiteration(@Valid User user, Model model){
//        System.out.println("User: " + user);
        Optional<User> optionalUser = userService.getUserByEmail(user.getEmail());

        if(optionalUser.isPresent()){
            model.addAttribute("error", "Email already in use!");

            List<UserType> userTypes = userTypeService.getAll();
            model.addAttribute("getAllTypes", userTypes);
            model.addAttribute("user", new User());
            return "register";
        }

        userService.addNewUser(user);

        return "dashboard";
    }

}

