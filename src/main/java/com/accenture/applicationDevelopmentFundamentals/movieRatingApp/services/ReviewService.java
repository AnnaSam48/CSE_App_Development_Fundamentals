package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.commands.CheckForExistingMovieCommand;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.commands.SaveCommand;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.MovieIdError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ApiClient.MovieAPIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReviewService {

    @Autowired
    MovieAPIRequest movieAPIRequest;
    @Autowired
    Prompter userInput;

    @Autowired
    CheckForExistingMovieCommand checkForExistingMovieCommand;

    @Autowired
    SaveCommand saveCommand;


    public Review writeReview(String movieId) {
        Review review = new Review();

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
        saveCommand.saveReview(review);
        return review;
    }

    private void setMovieInfoInReview(Review review, String movieId) {
        if (!checkForExistingMovieCommand.movieInfoExistsInRepository(movieId)) {
            Movie newMovie = movieAPIRequest.getMovieById(movieId);
            if (newMovie.getImdbID() == null) {
                throw new MovieIdError(movieId);
            }
            review.setMovieTitle(newMovie.getTitle());
            saveCommand.saveMovie(newMovie);
        } else {
            Movie existingMovie = checkForExistingMovieCommand.findByImdbId(movieId);
            review.setMovieTitle(existingMovie.getTitle());
        }

    }
}
