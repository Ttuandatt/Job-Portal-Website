package com.daniel.jobportal.controller;

import com.daniel.jobportal.dto.request.CreateUserRequest;
import com.daniel.jobportal.dto.response.ApiResponse;
import com.daniel.jobportal.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping("/login")
    ApiResponse<CreateUserRequest> createUser(@RequestBody @Valid CreateUserRequest request){
        return ApiResponse.<CreateUserRequest>builder()
                .result(userService.createUser(request))
                .build();
    }
}
