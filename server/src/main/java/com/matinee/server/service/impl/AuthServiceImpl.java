package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeUserDTO;
import com.matinee.server.dto.auth.SignInRequest;
import com.matinee.server.dto.auth.SignInResponse;
import com.matinee.server.dto.auth.SignUpRequest;
import com.matinee.server.dto.auth.SignUpResponse;
import com.matinee.server.exceptions.MatineeGenericException;
import com.matinee.server.mapper.MatineeUserMapper;
import com.matinee.server.service.AuthService;
import com.matinee.server.service.MatineeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    MatineeUserService matineeUserService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MatineeUserMapper matineeUserMapper;

    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        if(matineeUserService.existsByUsername(signUpRequest.getUsername())){
            throw new MatineeGenericException("Username already exists", HttpStatus.CONFLICT);
        }

        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        MatineeUserDTO matineeUserDTO = matineeUserMapper.convertSignUpRequestToDTO(signUpRequest);

        // TODO: Test this whether the password is encoded
        matineeUserDTO.setPasswordHash(encodedPassword);

        MatineeUser matineeUser = matineeUserService.addNewMatineeUser(matineeUserDTO);

        return matineeUserMapper.convertToSignUpResponse(matineeUser);
    }

    @Override
    public SignInResponse signIn(SignInRequest SignInRequest) {
        return null;
    }
}
