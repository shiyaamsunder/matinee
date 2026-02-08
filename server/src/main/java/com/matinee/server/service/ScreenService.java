package com.matinee.server.service;

import com.matinee.server.domain.entity.Screen;
import com.matinee.server.dto.ScreenDTO;

import java.util.UUID;

public interface ScreenService {

    Screen getScreenById(UUID screenId);

    Screen addNewScreen(ScreenDTO screenDTO);
}
