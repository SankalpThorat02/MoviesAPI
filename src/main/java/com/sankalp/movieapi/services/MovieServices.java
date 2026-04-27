package com.sankalp.movieapi.services;

import com.sankalp.movieapi.models.Movie;
import com.sankalp.movieapi.repositories.MovieRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServices {
    private final MovieRepositories movieRepository;

    public MovieServices(MovieRepositories movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAllMovies();
    }

    public Movie createMovie(Movie newMovie) {
        if(newMovie.getTitle() == null || newMovie.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty");
        }

        if(newMovie.getRating() == null || newMovie.getRating() < 1.0 || newMovie.getRating() > 10.0) {
            throw new IllegalArgumentException("Movie rating should be between 1.0 and 10.0");
        }

        return movieRepository.saveMovie(newMovie);
    }
}
