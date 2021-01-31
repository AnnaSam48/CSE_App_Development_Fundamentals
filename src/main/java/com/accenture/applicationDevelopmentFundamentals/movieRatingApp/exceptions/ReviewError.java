package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions;

public class ReviewError extends RuntimeException {

    public ReviewError(String exception) {
        super ("No review found for movie: " + exception + ". If you wish, you can create new review." );
    }
}
