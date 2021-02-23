package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.controllers;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.GetReviewsAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ApiClient.MovieAPIRequest;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ReviewService;
import com.google.gson.Gson;
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
    GetReviewsAction getReviewsAction;

    @GetMapping(value = "/search/{movieTitle}", produces = "application/json")
    public List<Review> searchReviews(@PathVariable String movieTitle) {
        return getReviewsAction.getMovieReviewsByMovieTitle(movieTitle);
    }

    @GetMapping(value="{/search-reviews/{movieId}", produces = "application/json")
        public List<Review> searchReviewsByMovieId(@PathVariable String movieId){
            return getReviewsAction.findAllReviewsByMovieId(movieId);
        }

    @GetMapping(value = "/add-review/{movieTitle}", produces = "application/json")
    public List<Movie> movies(@PathVariable String movieTitle) {
        return movieAPIRequest.getMoviesByTitle(movieTitle);
    }

    @PostMapping(value = "/add-review/addReview", produces = "application/json")
    public String reviewTitle(){
        String reviewObject = new String();
        Gson gson = new Gson();
        return gson.toJson(reviewObject);

    }


    @PostMapping(value = "/new-review/{id}")
    public Review newReview(@PathVariable String id) {
        return reviewService.writeReview(id);
    }
}
