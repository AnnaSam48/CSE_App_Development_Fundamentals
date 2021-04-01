package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.CheckForExistingMovieAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.SaveAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient.Request;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ReviewsServiceTest {

    private ReviewService reviewService;

    @Mock
    Request externalMovieRequest;

    @Mock
    CheckForExistingMovieAction checkForExistingMovieAction;

    @Mock
    SaveAction saveAction;

    @Test
    void addNewlyWrittenReviewTest(){

    }

}
