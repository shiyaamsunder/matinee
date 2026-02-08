package com.matinee.server.controller;


import com.matinee.server.mapper.MovieMapper;
import com.matinee.server.domain.entity.Movie;
import com.matinee.server.dto.MatineeResponse;
import com.matinee.server.dto.MovieDTO;
import com.matinee.server.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/matinee/api/v1/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieMapper movieMapper;

    @GetMapping("{id}")
    public ResponseEntity<MatineeResponse<MovieDTO>> getMovieById(@PathVariable UUID id){
        Movie movie =  movieService.getMovieById(id);
        MovieDTO movieResponse = movieMapper.convertToDTO(movie);
        return ResponseEntity.ok(
                MatineeResponse.<MovieDTO>builder()
                        .result(movieResponse)
                        .build()
        );
    }
}
