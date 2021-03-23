package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.CheckForExistingMovieAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.action.SaveAction;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.exceptions.MovieIdError;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.ReviewInputModel;
import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.services.movieAPIClient.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReviewService {

    @Autowired
    Request request;

    @Autowired
    CheckForExistingMovieAction checkForExistingMovieAction;

    @Autowired
    SaveAction saveAction;

    public Review addNewlyWrittenReview(ReviewInputModel reviewInputModel) {
        Review newMovieReview = new Review();
        if (!checkForExistingMovieAction.movieInfoExistsInRepository(reviewInputModel.getMovieId())) {
            Movie getNewMovieToAdd = request.getMovieById(reviewInputModel.getMovieId());
            if (getNewMovieToAdd.getImdbID() == null) {
                throw new MovieIdError(newMovieReview.getMovieId());
            }
            saveAction.saveMovie(getNewMovieToAdd);
            newMovieReview.setMovieTitle(getNewMovieToAdd.getTitle());
            newMovieReview.setMovieYear(getNewMovieToAdd.getYear());
        } else {
            Movie getMovieFromRepository = checkForExistingMovieAction.findByImdbId(reviewInputModel.getMovieId());
            newMovieReview.setMovieTitle(getMovieFromRepository.getTitle());
            newMovieReview.setMovieYear(getMovieFromRepository.getYear());
        }

        newMovieReview.setMovieId(reviewInputModel.getMovieId());
        newMovieReview.setMovieRating(reviewInputModel.getMovieRating());
        newMovieReview.setReviewTitle(reviewInputModel.getTitleForReview());
        newMovieReview.setReviewText(reviewInputModel.getReviewText());
        newMovieReview.setAuthor(reviewInputModel.getReviewAuthor());
        saveAction.saveReview(newMovieReview);

        return newMovieReview;
    }
}
