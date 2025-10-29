package com.daniel.jobportal.mapper;

import com.daniel.jobportal.dto.request.CreateUserRequest;
import com.daniel.jobportal.dto.response.UserResponse;
import com.daniel.jobportal.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(CreateUserRequest request);
    UserResponse toUserResponse(User user);
}
