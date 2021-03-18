package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class Response {


    List<Movie> Search;

    public List<Movie> getSearch() {
        return Search;
    }
}
