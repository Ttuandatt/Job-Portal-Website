package com.daniel.jobportal.service;

import com.daniel.jobportal.entity.User;
import com.daniel.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User addNewUser(User user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));

        return userRepository.save(user);
    }
}
