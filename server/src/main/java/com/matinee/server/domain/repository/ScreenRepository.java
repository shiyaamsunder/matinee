package com.matinee.server.domain.repository;

import com.matinee.server.domain.entity.Screen;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, UUID> {}
