package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.Showtime;
import com.matinee.server.dto.ShowtimeDTO;
import com.matinee.server.service.ShowtimeService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    @Override
    public Showtime getShowtimeById(UUID showtimeId) {
        return null;
    }

    @Override
    public Showtime addNewShowTime(ShowtimeDTO showtimeDTO) {
        return null;
    }
}
