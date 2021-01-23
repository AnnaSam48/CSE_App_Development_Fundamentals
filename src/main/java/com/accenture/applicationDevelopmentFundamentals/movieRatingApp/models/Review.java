package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    private String movieId;
    private String movieTitle;
    @Column(columnDefinition = "text", nullable=false)
    @Length(min =2, max=65535, message = "*Your review should be at least two characters long, but no longer than 65 535 characters.")
    @NotEmpty(message = "*Please type in your review")
    private String reviewText;
    private String userName;
    private int userRatingForMovie;
    private int movieAverageRating;


    public Review() {
    }

    public Review(Long reviewId, String movieId, String movieTitle,
                  @Length(min = 2, max = 65535, message = "*Your review should be at least two characters long, but no longer than 65 535 characters.")
                  @NotEmpty(message = "*Please type in your review") String reviewText,
                  String userName, int userRatingForMovie, int movieAverage) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.reviewText = reviewText;
        this.userName = userName;
        this.userRatingForMovie = userRatingForMovie;
        this.movieAverageRating = movieAverage;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public void setUserRatingForMovie(int userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public int getMovieAverage() {
        return movieAverageRating;
    }

    public void setMovieAverage(int movieAverage) {
        this.movieAverageRating = movieAverage;
    }
}
