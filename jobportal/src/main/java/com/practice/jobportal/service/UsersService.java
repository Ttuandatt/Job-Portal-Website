package com.practice.jobportal.service;

import com.practice.jobportal.entity.Users;
import com.practice.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users addNew(Users user){
        return usersRepository.save(user);
    }

    public Optional<Users> getByEmail(String email){
        return usersRepository.findByEmail(email);
    }

}
