package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.ApiClient;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ClientResponse {


    List<Movie> Search;

    public List<Movie> getSearch() {
        return Search;
    }
}
