package com.matinee.server.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Showtime")
public class Showtime extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID showtime_id;

    @OneToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column
    private LocalTime show_start;

    @Column
    private LocalTime show_end;
}
