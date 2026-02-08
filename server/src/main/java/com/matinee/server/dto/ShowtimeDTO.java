package com.matinee.server.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowtimeDTO {
    private UUID showtimeId;

    @NotBlank(message = "screenId should not be empty")
    private UUID screenId;

    @NotBlank(message = "movieId should not be empty")
    private UUID movieId;

    @NotBlank(message = "showStart should not be empty")
    private LocalTime showStart;

    @NotBlank(message = "showEnd should not be empty")
    private LocalTime showEnd;
}
