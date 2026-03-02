package com.matinee.server.controller;

import com.matinee.server.dto.MatineeResponse;
import com.matinee.server.dto.auth.SignUpRequest;
import com.matinee.server.dto.auth.SignUpResponse;
import com.matinee.server.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matinee/api/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/signup")

    public ResponseEntity<MatineeResponse<SignUpResponse>> signUp(@Valid @RequestBody SignUpRequest signUpRequest){
       SignUpResponse response =  authService.signUp(signUpRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MatineeResponse.<SignUpResponse>builder()
                        .result(response).build());
    }
}
