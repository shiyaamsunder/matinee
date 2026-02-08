package com.matinee.server.service;

import com.matinee.server.domain.entity.Showtime;
import com.matinee.server.dto.ShowtimeDTO;

import java.util.UUID;

public interface ShowtimeService {

    Showtime getShowtimeById(UUID showtimeId);

    Showtime addNewShowTime(ShowtimeDTO showtimeDTO);
}
