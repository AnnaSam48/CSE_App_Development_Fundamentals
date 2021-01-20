package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class MovieAPIRequest {

    @Value("${openmoviedb.api.request}")
    private String requestURL;

    private String getPreparedSearchKeyword(String keyword){
        keyword = keyword.trim();
        String preparedSearchKeyword = keyword.replaceAll(" ", "%20");
        return preparedSearchKeyword;
    }

    private String getJsonResponse(URL url) throws Exception {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(3000);
        urlConnection.connect();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        String JsonResponse = stringBuilder.toString();
        bufferedReader.close();

        return JsonResponse;
    }

}
