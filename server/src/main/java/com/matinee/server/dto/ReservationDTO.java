package com.matinee.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDTO {

    private UUID reservationId;

    @NotBlank(message = "userId should not be empty")
    private UUID userId;

    @NotBlank(message = "showtimeId should not be empty")
    private UUID showtimeId;

    @NotBlank(message = "count should not be empty")
    private Integer count;

    @NotBlank(message = "price should not be empty")
    private BigDecimal price;

    private Boolean completed;

    private Boolean cancelled;
}
