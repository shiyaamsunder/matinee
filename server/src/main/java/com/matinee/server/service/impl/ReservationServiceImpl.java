package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.Reservation;
import com.matinee.server.dto.ReservationDTO;
import com.matinee.server.service.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Override
    public Reservation getReservationById(UUID reservationId) {
        return null;
    }

    @Override
    public List<Reservation> getReservationByUserId(UUID userId) {
        return List.of();
    }

    @Override
    public Reservation addNewReservation(ReservationDTO reservationDTO) {
        return null;
    }
}
