package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions;

public class TechnicalError extends RuntimeException {

    public TechnicalError(String exception) {
        super ("Experiencing technical difficulties. " + exception );
    }
}
