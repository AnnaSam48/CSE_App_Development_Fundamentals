package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.controllers;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.GetReviewsAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.ReviewInputModel;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient.Request;
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
    Request request;
    @Autowired
    GetReviewsAction getReviewsAction;


    /*Returns all reviews with same movie title (might be more than one movie with title,
     so not very precise search, however might be used to inspire to watch some other movie with same title)  */
    @GetMapping(value = "/search/{movieTitle}", produces = "application/json")
    public List<Review> searchReviews(@PathVariable String movieTitle) {
        return getReviewsAction.getMovieReviewsByMovieTitle(movieTitle);
    }

    // Returns reviews for movie using movieId better than search by title
    @GetMapping(value = "{/search-reviews/{movieId}", produces = "application/json")
    public List<Review> searchReviewsByMovieId(@PathVariable String movieId) {
        return getReviewsAction.findAllReviewsByMovieId(movieId);
    }

    // Find movie for review
    @GetMapping(value = "/add-review/{movieTitle}", produces = "application/json")
    public List<Movie> getPossibleReviewMovies(@PathVariable String movieTitle) {
        return request.getMoviesByTitle(movieTitle);
    }

    // Add review in json string format
    @PostMapping(value = "/add-review/add")
    @ResponseBody
    public Review addNewReview(@RequestBody ReviewInputModel reviewInputModel) {
        return reviewService.addNewlyWrittenReview(reviewInputModel);
    }
}
