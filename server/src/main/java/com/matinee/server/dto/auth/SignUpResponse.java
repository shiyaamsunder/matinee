package com.matinee.server.dto.auth;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class SignUpResponse {
    private UUID id;
}
