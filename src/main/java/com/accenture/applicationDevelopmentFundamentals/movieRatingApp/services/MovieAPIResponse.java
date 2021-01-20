package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;

import java.util.List;

public class MovieAPIResponse {

    private List<Movie> Search;

    private String Response;

    public List<Movie> getSearch() {
        return Search;
    }
}
