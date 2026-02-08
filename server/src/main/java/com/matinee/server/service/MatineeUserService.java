package com.matinee.server.service;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeUserDTO;

import java.util.UUID;


public interface MatineeUserService {

    MatineeUser addNewMatineeUser(MatineeUserDTO matineeUserDTO);

    MatineeUser getMatineeUserById(UUID userId);

    MatineeUser getMatineeUserByUserName(String username);

    MatineeUser updateMatineeUser(MatineeUserDTO matineeUserDTO);

    MatineeUser removeMatineeUser(MatineeUserDTO matineeUserDTO);
}
