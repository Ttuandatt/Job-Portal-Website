package com.practice.jobportal.controller;

import com.practice.jobportal.entity.Users;
import com.practice.jobportal.entity.UsersType;
import com.practice.jobportal.service.UsersService;
import com.practice.jobportal.service.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }


    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();

        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());

        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users user, Model model) {
        Optional<Users> optionalUsers = usersService.getByEmail(user.getEmail());

        if(optionalUsers.isPresent()) {
            model.addAttribute("error", "Email already exists. Try with another email.");

            List<UsersType> usersTypes = usersTypeService.getAll();
            model.addAttribute("getAllTypes", usersTypes);
            model.addAttribute("user", new Users());
            return "register";
        }

        usersService.addNew(user);
        return "dashboard";
    }

}
