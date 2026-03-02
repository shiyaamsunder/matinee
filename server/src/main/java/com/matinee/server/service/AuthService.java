package com.matinee.server.service;

import com.matinee.server.dto.auth.SignInRequest;
import com.matinee.server.dto.auth.SignInResponse;
import com.matinee.server.dto.auth.SignUpRequest;
import com.matinee.server.dto.auth.SignUpResponse;

public interface AuthService {

    SignUpResponse signUp(SignUpRequest signUpRequest);

    SignInResponse signIn(SignInRequest SignInRequest);
}
