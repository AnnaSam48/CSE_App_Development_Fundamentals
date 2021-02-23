package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.ReviewError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class GetReviewsAction {

    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getMovieReviewsByMovieTitle(@RequestParam String movieTitle) {
        List<Review> reviewsFound = reviewRepository.findByMovieTitle(movieTitle);
        if (reviewsFound.isEmpty()) {
            throw new ReviewError(movieTitle);
        }
        return reviewsFound;
    }

    public List<Review> findAllReviewsByMovieId(@RequestParam String movieId) {
        List<Review> reviewsFound = reviewRepository.findAllByMovieId(movieId);
        if (reviewsFound.isEmpty()) {
            throw new ReviewError(movieId);
        }
        return reviewsFound;
    }
}
