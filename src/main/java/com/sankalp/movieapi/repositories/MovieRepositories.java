package com.sankalp.movieapi.repositories;

import com.sankalp.movieapi.models.Movie;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositories {
    private List<Movie> database = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Movie> findAllMovies() {
        return database;
    }

    public Movie saveMovie(Movie newMovie) {
        newMovie.setId(idCounter);
        database.add(newMovie);
        idCounter++;

        return newMovie;
    }
}
