package com.matinee.server.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {
    @NotBlank(message = "username should not be empty")
    private String userName;

    @NotBlank(message = "password should not be empty")
    private String password;
}
