package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.domain.repository.MatineeUserRepository;
import com.matinee.server.exceptions.MatineeNotFoundException;
import com.matinee.server.service.MatineeUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MatineeUserServiceImpl implements MatineeUserService {

    @Autowired
    MatineeUserRepository matineeUserRepository;

    @Override
    public MatineeUser addNewMatineeUser(MatineeUser matineeUser){
        return matineeUserRepository.save(matineeUser);
    }

    @Override
    public MatineeUser getMatineeUserById(UUID userId) {

       return matineeUserRepository.findById(userId)
               .orElseThrow(() -> new MatineeNotFoundException("User not found"));
    }

    @Override
    public MatineeUser getMatineeUserByUserName(String username){

        return matineeUserRepository.findByUserName(username)
                .orElseThrow(() -> new MatineeNotFoundException("User not found"));
    }

    @Override
    public MatineeUser updateMatineeUser(MatineeUser matineeUser){
        return null;
    }

    @Override
    public MatineeUser removeMatineeUser(MatineeUser matineeUser) {
        return null;
    }
}
