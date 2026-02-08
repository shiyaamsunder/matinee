package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.Screen;
import com.matinee.server.dto.ScreenDTO;
import com.matinee.server.service.ScreenService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Override
    public Screen getScreenById(UUID screenId) {
        return null;
    }

    @Override
    public Screen addNewScreen(ScreenDTO screenDTO) {
        return null;
    }
}
