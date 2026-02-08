package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.domain.repository.MatineeUserRepository;
import com.matinee.server.dto.MatineeUserDTO;
import com.matinee.server.exceptions.MatineeNotFoundException;
import com.matinee.server.mapper.MatineeUserMapper;
import com.matinee.server.service.MatineeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MatineeUserServiceImpl implements MatineeUserService {

    @Autowired
    MatineeUserRepository matineeUserRepository;

    @Autowired
    MatineeUserMapper matineeUserMapper;

    @Override
    public MatineeUser addNewMatineeUser(MatineeUserDTO matineeUserDTO){
        MatineeUser matineeUser = matineeUserMapper.convertToEntity(matineeUserDTO);
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
    public MatineeUser updateMatineeUser(MatineeUserDTO matineeUserDTO){
        return null;
    }

    @Override
    public MatineeUser removeMatineeUser(MatineeUserDTO matineeUserDTO) {
        return null;
    }
}
