package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.controllers;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories.ReviewRepository;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewRestController {

    @Autowired
    Review review;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ReviewService reviewService;


    @GetMapping(value = "/{movieTitle}")
    public List<Review> getReviewsForMovie(@PathVariable String movieTitle){
        return reviewRepository.findAllByMovieTitle(movieTitle);
    }

    @PostMapping("/{movieTitle}")
    public Review addReview(@PathVariable String movieId, Review reviewWritten){
        return reviewService.newReviewToAdd(movieId, reviewWritten);
    }
}
