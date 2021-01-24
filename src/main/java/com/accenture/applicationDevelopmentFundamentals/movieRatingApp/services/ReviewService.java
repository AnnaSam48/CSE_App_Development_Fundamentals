package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.MovieRepository;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.ReviewRepository;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.externalAPIServices.MovieAPIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;

@Service
public class ReviewService {

    @Autowired
    Movie movie;
    @Autowired
    Review review;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieAPIRequest movieAPIRequest;
    @Autowired
    UsersInputService usersInputService;

    public Review newReviewToAdd(@PathVariable String movieId, @Valid Review reviewToBeAdded) {

        //Fetch movie via API call only, if it's data are not in database
        //TODO exception handling
        if (!movieRepository.existsById(movieId)) {
            Movie newMovie = movieAPIRequest.getMovieById(movieId);

            if (newMovie == null) {
                throw new RuntimeException();
            }

            reviewToBeAdded.setMovieId(movieId);
            reviewToBeAdded.setMovieTitle(newMovie.getTitle());
            movieRepository.save(newMovie);
            reviewToBeAdded.setUserRatingForMovie(usersInputService.getUsersRatingForMovie());
            reviewToBeAdded.setMovieAverage(usersInputService.getUsersRatingForMovie());

            //if movie already has reviews
        } else {

            Movie movieWithNewReview = movieRepository.findByImdbId(movieId);
            reviewToBeAdded.setMovieId(movieId);
            reviewToBeAdded.setMovieTitle(movieWithNewReview.getTitle());
            reviewToBeAdded.setUserRatingForMovie(usersInputService.getUsersRatingForMovie());
            reviewToBeAdded.setMovieAverage(reviewRepository.average(movieId));
        }

            reviewToBeAdded.setReviewTitle(usersInputService.getReviewTitle());
            reviewToBeAdded.setReviewText(usersInputService.getReviewText());
            reviewToBeAdded.setAuthor(usersInputService.getAuthor());

            reviewRepository.save(reviewToBeAdded);

        return reviewToBeAdded;
    }

}
