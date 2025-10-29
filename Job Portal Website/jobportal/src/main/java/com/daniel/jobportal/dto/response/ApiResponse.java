package com.daniel.jobportal.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ApiResponse<T> {
    @Builder.Default // Set the default value for code to ensure success code is 1000
    int code = 1000; // Default success code
    String message;
    T result;
}
