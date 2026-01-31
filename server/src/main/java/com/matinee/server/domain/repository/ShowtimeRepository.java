package com.matinee.server.domain.repository;

import com.matinee.server.domain.entity.Showtime;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime, UUID> {}
