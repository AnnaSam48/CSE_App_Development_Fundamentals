package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
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

    private String getPreparedSearchKeyword(String keyword) {
        keyword = keyword.trim();
        return keyword.replaceAll(" ", "%20");
    }

    //TODO:Exception handling
    private String getJsonResponse(URL url) throws Exception {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(3000);
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }

        String jsonResponse = stringBuilder.toString();
        bufferedReader.close();

        return jsonResponse;
    }

    public List<Movie> getMoviesByTitle(String movieTitle) {
        String requestedMovie = getPreparedSearchKeyword(movieTitle);
        String jsonResponse;

        try {
            URL url = new URL(requestURL + requestByTitlePrefix + requestedMovie);
            jsonResponse = getJsonResponse(url);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

        Gson gson = new Gson();
        MovieAPIResponse movieAPIResponse = gson.fromJson(jsonResponse, MovieAPIResponse.class);
        List<Movie> listOfFoundMovies = movieAPIResponse.getSearch();

        if (listOfFoundMovies == null) {
            throw new RuntimeException();
        }

        return listOfFoundMovies;
    }

    public Movie getMovieByID(String movieId) {
        try {
            URL url = new URL(requestURL + requestByIdPrefix + movieId);
            String jsonResponse = getJsonResponse(url);
            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, Movie.class);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
