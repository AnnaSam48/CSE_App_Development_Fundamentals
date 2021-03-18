package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.MovieTitleError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.TechnicalError;
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
public class Request {

    @Value("${openmoviedb.api.request}")
    private String requestURL;
    @Value("${request.by.title.prefix}")
    private String requestByTitlePrefix;
    @Value("${request.by.id.prefix}")
    private String requestByIdPrefix;

    private String getPreparedSearchKeyword(String keyword) {
        return keyword.trim().replace(" ", "%20");
    }

    public List<Movie> getMoviesByTitle(String movieTitle) {

        String requestedMovie = getPreparedSearchKeyword(movieTitle);
        String jsonResponse;

        try {
          URL url = new URL(requestURL + requestByTitlePrefix + requestedMovie);
          jsonResponse = getJsonResponse(url);
        } catch (Exception e) {
            throw new TechnicalError(e.toString());
        }

        Gson gson = new Gson();
        Response response = gson.fromJson(jsonResponse, Response.class);
        List<Movie> moviesFound = response.getSearch();

        if (moviesFound == null) {
            throw new MovieTitleError(requestedMovie);
        }
        return moviesFound;
    }

    public Movie getMovieById(String movieId) {
        try {
            URL url = new URL(requestURL + requestByIdPrefix + movieId);
            String jsonResponse = getJsonResponse(url);
            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, Movie.class);
        } catch (Exception e) {
            throw new TechnicalError(e.toString());
        }
    }

    String getJsonResponse(URL url) throws Exception {
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
}
