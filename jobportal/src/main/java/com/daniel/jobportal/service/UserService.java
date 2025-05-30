package com.daniel.jobportal.service;

import com.daniel.jobportal.entity.JobSeekerProfile;
import com.daniel.jobportal.entity.RecruiterProfile;
import com.daniel.jobportal.entity.User;
import com.daniel.jobportal.repository.JobSeekerProfileRepository;
import com.daniel.jobportal.repository.RecruiterProfileRepository;
import com.daniel.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, RecruiterProfileRepository recruiterProfileRepository, JobSeekerProfileRepository jobSeekerProfileRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User addNewUser(User user) {
        user.setActive(true);
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));   // Encrypt user password during registration
        User savedUser = userRepository.save(user);

        int userTypeId = user.getUserTypeId().getUserTypeId();  //.getUserTypeId().getUserTypeId(): getUserTypeId() thứ nhất là lấy đối tượng userTypeId kiểu UserType ở class User, getUserTypeId() thứ hai là lấy đối tượng userTypeId kiểu Int của đối tượng UserType vừa lấy được, cái này do vô tình đặt tên giống nhau nên bị trùng nhau
        if(userTypeId == 1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        }else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }

        return savedUser;
    }
}
