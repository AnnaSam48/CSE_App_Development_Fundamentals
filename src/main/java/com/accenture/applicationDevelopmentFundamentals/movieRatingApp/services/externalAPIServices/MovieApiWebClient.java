package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.externalAPIServices;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieApiWebClient {

    @Autowired
    WebClient.Builder webClientBuilder;

    //TODO exception handling
    public List<Movie> getMoviesByTitleList(URL url) {
        try {
           return webClientBuilder.build()
                    .get()
                    .uri(""+url)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToFlux(Movie.class)
                    .collectList()
                    .block();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public Movie getMovieById(URL url){
        try {
            return webClientBuilder.build()
                    .get()
                    .uri(""+url)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
