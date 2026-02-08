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
public class ScreenDTO {

    private UUID screenId;

    @NotBlank(message = "screenName should not be empty")
    private String screenName;

    private Integer capacity;

    private String audioType;

    private String projectionType;

    private String resolution;
}
