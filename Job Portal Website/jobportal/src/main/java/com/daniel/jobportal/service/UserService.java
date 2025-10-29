package com.daniel.jobportal.service;

import com.daniel.jobportal.dto.request.CreateUserRequest;
import com.daniel.jobportal.dto.response.UserResponse;
import com.daniel.jobportal.entity.User;
import com.daniel.jobportal.exception.AppException;
import com.daniel.jobportal.exception.ErrorCode;
import com.daniel.jobportal.mapper.UserMapper;
import com.daniel.jobportal.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;

    public UserResponse createUser(CreateUserRequest request){
        // Check if user already exists
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXIST);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toUserResponse(userRepository.save(userMapper.toUser(request)));
    }
}
