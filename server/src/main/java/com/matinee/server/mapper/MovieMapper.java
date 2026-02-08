package com.matinee.server.mapper;

import com.matinee.server.domain.entity.Movie;
import com.matinee.server.dto.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    Movie convertToEntity(MovieDTO movieDTO);
    MovieDTO convertToDTO(Movie movie);
}
