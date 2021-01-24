package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.controllers;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.externalAPIServices.MovieAPIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieRestController {

    @Autowired
    MovieAPIRequest movieAPIRequest;

    @GetMapping(value = "/{movieTitle}", produces = "application/json")
    public List<Movie> getMoviesForReview(@PathVariable String movieTitle){
        return movieAPIRequest.getMoviesByTitle(movieTitle);
    }

    @GetMapping(value="/{movieId}", produces = "application/json")
    public Movie getMovieById(@PathVariable String id){
        return movieAPIRequest.getMovieById(id);
    }

}
