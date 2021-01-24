package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.externalAPIServices;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.UsersInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Component
public class MovieAPIRequest {

    @Value("${openmoviedb.api.request}")
    private String requestURL;
    @Value("${request.by.title.prefix}")
    private String requestByTitlePrefix;
    @Value("${request.by.id.prefix}")
    private String requestByIdPrefix;

    @Autowired
    UsersInputService usersInputService;
    @Autowired
    MovieApiWebClient movieApiWebClient;

    private String getPreparedSearchKeyword(String keyword) {
        keyword = usersInputService.getMovieTitle().trim();
        return keyword.replaceAll(" ", "%20");
    }

    //TODO:Exception handling
    public List<Movie> getMoviesByTitle(String movieTitle) {
        String requestedMovie = getPreparedSearchKeyword(movieTitle);

        try {
            URL url = new URL(requestURL + requestByTitlePrefix + requestedMovie);

            if (movieApiWebClient.getMoviesByTitleList(url) == null) {
                throw new RuntimeException();
            }

            return movieApiWebClient.getMoviesByTitleList(url);

        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    public Movie getMovieById(String movieId) {
        try {
            URL url = new URL(requestURL + requestByIdPrefix + movieId);
           return movieApiWebClient.getMovieById(url);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
