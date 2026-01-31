package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.domain.repository.MatineeUserRepository;
import com.matinee.server.service.MatineeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatineeUserServiceImpl implements MatineeUserService {


    @Autowired
    MatineeUserRepository matineeUserRepository;

    public MatineeUser addNewMatineeUser(MatineeUser matineeUser){
        return matineeUserRepository.save(matineeUser);
    }
}
