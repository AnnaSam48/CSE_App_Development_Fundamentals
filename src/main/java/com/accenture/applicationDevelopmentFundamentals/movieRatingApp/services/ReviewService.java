package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.CheckForExistingMovieAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.SaveAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.MovieIdError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ApiClient.MovieAPIRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReviewService {

    @Autowired
    MovieAPIRequest movieAPIRequest;
    @Autowired
    Converter userInput;

    @Autowired
    CheckForExistingMovieAction checkForExistingMovieAction;

    @Autowired
    SaveAction saveAction;


    public Review writeReview(String movieId) {
        Review review = new Review();
        Gson gson = new Gson();

        setMovieInfoInReview(review, movieId);
        String reviewTitle = userInput.getReviewTitle(review.getMovieTitle());
        String reviewText = userInput.getReviewText();
        String author = userInput.getAuthor();
        int movieRating = userInput.getMovieRating();
        review.setReviewText(reviewText);
        review.setReviewTitle(reviewTitle);
        review.setMovieId(movieId);
        review.setMovieRating(movieRating);
        review.setAuthor(author);
        saveAction.saveReview(review);
        return review;
    }

    private void setMovieInfoInReview(Review review, String movieId) {
        if (!checkForExistingMovieAction.movieInfoExistsInRepository(movieId)) {
            Movie newMovie = movieAPIRequest.getMovieById(movieId);
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
