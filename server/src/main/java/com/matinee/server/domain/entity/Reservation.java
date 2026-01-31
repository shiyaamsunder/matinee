package com.matinee.server.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Reservation")
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID reservation_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private MatineeUser user;

    @OneToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    @Column
    private Integer count;

    @Column
    private BigDecimal price;

    @Column
    private Boolean completed;

    @Column
    private Boolean cancelled;
}
