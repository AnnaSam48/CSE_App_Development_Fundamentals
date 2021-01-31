package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions;

public class MovieIdError extends RuntimeException {

    public MovieIdError(String exception) {
        super ("No movie with such id was found: " + exception );
    }
}
