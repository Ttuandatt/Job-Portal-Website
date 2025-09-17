package com.practice.jobportal.service;

import com.practice.jobportal.entity.JobSeekerProfile;
import com.practice.jobportal.entity.RecruiterProfile;
import com.practice.jobportal.entity.Users;
import com.practice.jobportal.entity.UsersType;
import com.practice.jobportal.repository.JobSeekerProfileRepository;
import com.practice.jobportal.repository.RecruiterProfileRepository;
import com.practice.jobportal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    public Users addNew(Users user){
        user.setIs_active(true);
        user.setRegistration_date(new Date(System.currentTimeMillis()));

        Users newUser = usersRepository.save(user);
        int userType = newUser.getUser_type_id().getUser_type_id();

        if(userType == 1){
            recruiterProfileRepository.save(new RecruiterProfile(newUser));
        }else{
            jobSeekerProfileRepository.save(new JobSeekerProfile(newUser));
        }

        return newUser;
    }

    public Optional<Users> getByEmail(String email){
        return usersRepository.findByEmail(email);
    }

}
