package com.matinee.server.service;

import com.matinee.server.domain.entity.Reservation;
import com.matinee.server.dto.ReservationDTO;

import java.util.List;
import java.util.UUID;

public interface ReservationService {

    Reservation getReservationById(UUID reservationId);

    List<Reservation> getReservationByUserId(UUID userId);

    Reservation addNewReservation(ReservationDTO reservationDTO);

}
