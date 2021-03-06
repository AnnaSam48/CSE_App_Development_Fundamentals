package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckForExistingMovieAction {

    @Autowired
    MovieRepository movieRepository;

    public boolean movieInfoExistsInRepository(String movieId) {
        return movieRepository.findByImdbID(movieId) != null;
    }

    public Movie findByImdbId(String movieId) {
        return movieRepository.findByImdbID(movieId);
    }
}
