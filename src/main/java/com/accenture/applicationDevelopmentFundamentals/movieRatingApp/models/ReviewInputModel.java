package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

public class ReviewInputModel {

    private String movieId;
    private int movieRating;
    private String titleForReview;
    private String reviewText;
    private String reviewAuthor;

    public ReviewInputModel() {
    }

    public ReviewInputModel(String movieId, int movieRating, String titleForReview,
                            String reviewText, String reviewAuthor) {
        this.movieId = movieId;
        this.movieRating = movieRating;
        this.titleForReview = titleForReview;
        this.reviewText = reviewText;
        this.reviewAuthor = reviewAuthor;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getTitleForReview() {
        return titleForReview;
    }

    public void setTitleForReview(String titleForReview) {
        this.titleForReview = titleForReview;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }
}
