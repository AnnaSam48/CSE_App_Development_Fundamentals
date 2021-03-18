package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.CheckForExistingMovieAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.SaveAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.MovieIdError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.TechnicalError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient.Request;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


@Component
public class ReviewService {

    @Autowired
    Request request;

    @Autowired
    CheckForExistingMovieAction checkForExistingMovieAction;

    @Autowired
    SaveAction saveAction;

    public Review writeReview(String movieId) {

        return null;
    }

    private void setMovieInfoInReview(Review review, String movieId) {
        if (!checkForExistingMovieAction.movieInfoExistsInRepository(movieId)) {
            Movie newMovie = request.getMovieById(movieId);
            if (newMovie.getImdbID() == null) {
                throw new MovieIdError(movieId);
            }
            review.setMovieTitle(newMovie.getTitle());
            saveAction.saveMovie(newMovie);
        } else {
            Movie existingMovie = checkForExistingMovieAction.findByImdbId(movieId);
            review.setMovieTitle(existingMovie.getTitle());
        }

    }
}
