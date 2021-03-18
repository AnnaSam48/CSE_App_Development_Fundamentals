package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.controllers;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.GetReviewsAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient.Request;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ReviewService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


@RestController
@RequestMapping("movies")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    Request request;
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
        return request.getMoviesByTitle(movieTitle);
    }

    @PostMapping(value = "/add-review/add", produces = "application/json", consumes = "application/json")
    public Review addNewReview(){
        String reviewObject = new String();
        Gson gson = new Gson();
        return gson.fromJson(reviewObject, Review.class);
    }


    @PostMapping(value = "/new-review/{id}")
    public Review newReview(@PathVariable String id) {
        return reviewService.writeReview(id);
    }
}
