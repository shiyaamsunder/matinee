package com.matinee.server.service;


import com.matinee.server.domain.entity.Movie;
import com.matinee.server.dto.MovieDTO;

import java.util.UUID;

public interface MovieService {

    Movie getMovieById(UUID movieId);

    Movie getMovieByTitle(String movieTitle);

    Movie addNewMovie(MovieDTO movieDTO);

}
