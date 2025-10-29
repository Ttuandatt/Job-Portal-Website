package com.daniel.jobportal.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    @Size(min=5, max=20, message = "INALID_USERNAME")
    String username;
    @Size(min=10)
    String password;
    String firstName;
    String lastName;
    String email;
    LocalDate dob; //yyyy-mm-dd
}
