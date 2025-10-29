package com.daniel.jobportal.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    INVALID_USERNAME(1001, "Username must be between 3 and 20 characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1002, "Password must be at least 10 characters long", HttpStatus.BAD_REQUEST),
    USER_EXIST(1003, "User already exists", HttpStatus.BAD_REQUEST),;

    int code;
    String message;
    HttpStatusCode httpStatusCode;

}
