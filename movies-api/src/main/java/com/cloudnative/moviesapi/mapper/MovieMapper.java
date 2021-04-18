package com.cloudnative.moviesapi.mapper;

import com.cloudnative.moviesapi.model.Movie;
import com.cloudnative.moviesapi.rest.dto.CreateMovieDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie toMovie(CreateMovieDto createMovieDto);

}
