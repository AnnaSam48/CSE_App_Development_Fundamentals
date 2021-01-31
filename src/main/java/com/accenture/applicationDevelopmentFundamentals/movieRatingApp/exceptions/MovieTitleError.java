package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions;

public class MovieTitleError extends RuntimeException {

    public MovieTitleError(String exception) {
        super ("Movie with such name was not found: " + exception );
    }
}
