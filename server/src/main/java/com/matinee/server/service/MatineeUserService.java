package com.matinee.server.service;

import com.matinee.server.domain.entity.MatineeUser;
import com.matinee.server.dto.MatineeUserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;


public interface MatineeUserService extends UserDetailsService {

    MatineeUser addNewMatineeUser(MatineeUserDTO matineeUserDTO);

    MatineeUser getMatineeUserById(UUID userId);

    MatineeUser getMatineeUserByUserName(String username);

    boolean existsByUsername(String username);

    MatineeUser updateMatineeUser(MatineeUserDTO matineeUserDTO);

    MatineeUser removeMatineeUser(MatineeUserDTO matineeUserDTO);
}
