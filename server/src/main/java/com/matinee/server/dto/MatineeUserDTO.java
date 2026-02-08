package com.matinee.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatineeUserDTO {

    private UUID userId;

    @NotBlank(message = "userName should not be empty")
    private String userName;

    @NotBlank(message = "passwordHash should not be empty")
    private String passwordHash;

    private String role;

}
