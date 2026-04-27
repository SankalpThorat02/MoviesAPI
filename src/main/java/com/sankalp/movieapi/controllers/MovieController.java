package com.sankalp.movieapi.controllers;

import com.sankalp.movieapi.models.Movie;
import com.sankalp.movieapi.services.MovieServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieServices movieService;

    public MovieController(MovieServices movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> findAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie newMovie) {
        return movieService.createMovie(newMovie);
    }
}
