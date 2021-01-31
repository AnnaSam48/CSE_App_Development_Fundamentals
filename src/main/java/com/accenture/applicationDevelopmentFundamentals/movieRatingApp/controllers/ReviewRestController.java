package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.controllers;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.commands.GetReviewsCommand;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ApiClient.MovieAPIRequest;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("movies")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    MovieAPIRequest movieAPIRequest;
    @Autowired
    GetReviewsCommand getReviewsCommand;

    @GetMapping(value = "/search/{movieTitle}", produces = "application/json")
    public List<Review> searchReviews(@PathVariable String movieTitle) {
        return getReviewsCommand.getMovieReviews(movieTitle);
    }

    @GetMapping(value="{/search-reviews/{movieId}", produces = "application/json")
        public List<Review> searchReviewsByMovieId(@PathVariable String movieId){
            return getReviewsCommand.findAllReviewsByMovieId(movieId);
        }

    @GetMapping(value = "/add-review/{movieTitle}", produces = "application/json")
    public List<Movie> movies(@PathVariable String movieTitle) {
        return movieAPIRequest.getMoviesByTitle(movieTitle);
    }

    @PostMapping(value = "/new-review/{id}")
    public Review newReview(@PathVariable String id) {
        return reviewService.writeReview(id);
    }
}
