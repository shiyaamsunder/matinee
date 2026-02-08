package com.matinee.server.service;

import com.matinee.server.domain.entity.MatineeUser;

import java.util.UUID;


public interface MatineeUserService {

    MatineeUser addNewMatineeUser(MatineeUser matineeUser);

    MatineeUser getMatineeUserById(UUID userId);

    MatineeUser getMatineeUserByUserName(String username);

    MatineeUser updateMatineeUser(MatineeUser updatedMatineeUser);

    MatineeUser removeMatineeUser(MatineeUser matineeUser);
}
