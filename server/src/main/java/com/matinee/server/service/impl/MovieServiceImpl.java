package com.matinee.server.service.impl;

import com.matinee.server.domain.entity.Movie;
import com.matinee.server.domain.repository.MovieRepository;
import com.matinee.server.dto.MovieDTO;
import com.matinee.server.exceptions.MatineeNotFoundException;
import com.matinee.server.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public Movie getMovieById(UUID movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new MatineeNotFoundException("Movie not found"));
    }

    @Override
    public Movie getMovieByTitle(String movieTitle) {
        return null;
    }

    @Override
    public Movie addNewMovie(MovieDTO movieDTO) {
        return null;
    }
}
