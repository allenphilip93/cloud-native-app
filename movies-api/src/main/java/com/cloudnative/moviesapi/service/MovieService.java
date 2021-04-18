package com.cloudnative.moviesapi.service;

import com.cloudnative.moviesapi.model.Movie;

import java.util.List;

public interface MovieService {

    Movie validateAndGetMovie(String imdb);

    List<Movie> getMovies();

    Movie createMovie(Movie movie);

    void deleteMovie(Movie movie);

}
