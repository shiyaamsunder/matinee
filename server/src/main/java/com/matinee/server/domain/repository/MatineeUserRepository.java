package com.matinee.server.domain.repository;

import com.matinee.server.domain.entity.MatineeUser;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatineeUserRepository
    extends JpaRepository<MatineeUser, UUID> {}
