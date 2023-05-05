package com.example.backend.requests;

import com.example.backend.entity.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder

public class UserDto {

    @NotBlank(message = "USERNAME CANNOT BE BLANK")
    @NotNull(message = "USERNAME CANNOT BE NULL")
    String username;

    @NotBlank(message = "PASSWORD CANNOT BE BLANK")
    @NotNull(message = "PASSWORD CANNOT BE NULL")
    String password;

    String accessToken;

    String refreshToken;

    Role role;
    

}
