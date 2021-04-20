package com.cloudnative.moviesapi.repository;

import com.cloudnative.moviesapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
