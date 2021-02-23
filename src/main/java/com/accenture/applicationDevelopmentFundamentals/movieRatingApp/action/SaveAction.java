package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.MovieRepository;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveAction {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ReviewRepository reviewRepository;

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
    public void saveReview(Review newReview) {
        reviewRepository.save(newReview);
    }
}
