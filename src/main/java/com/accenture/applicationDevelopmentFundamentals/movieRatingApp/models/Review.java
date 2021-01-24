package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Review implements Serializable {

    @ApiModelProperty(notes="Review id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    @ApiModelProperty(notes="Movie id")
    private String movieId;
    @ApiModelProperty(notes="Movie title")
    private String movieTitle;
    @ApiModelProperty(notes="Review title")
    @Column(columnDefinition = "text", nullable = false)
    @Length(min = 3, max=160, message = "*Your review must have title at least 3 characters long, but no longer than 160 characters.")
    @NotEmpty(message = "*Please type in your review title")
    private String reviewTitle;
    @ApiModelProperty(notes="Review")
    @Column(columnDefinition = "text", nullable=false)
    @Length(min =2, max=65535, message = "*Your review should be at least two characters long, but no longer than 65 535 characters.")
    @NotEmpty(message = "*Please type in your review")
    private String reviewText;
    @ApiModelProperty(notes="Author of the review")
    private String author;
    @ApiModelProperty(notes="User's rating for movie")
    private int userRatingForMovie;
    @ApiModelProperty(notes="Movie rating (average from all given ratings for this movie)")
    private Integer movieAverageRating;


    public Review() {
    }

    public Review(Long reviewId, String movieId, String movieTitle,
                  @Length(min = 3, max=160, message = "*Your review must have title at least 3 characters long, but no longer than 160 characters.")
                  @NotEmpty(message = "*Please type in your review title") String reviewTitle,
                  @Length(min = 2, max = 65535, message = "*Your review should be at least two characters long, but no longer than 65 535 characters.")
                  @NotEmpty(message = "*Please type in your review") String reviewText,
                  String author, int userRatingForMovie, Integer movieAverage) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.author = author;
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

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUserRatingForMovie() {
        return userRatingForMovie;
    }

    public void setUserRatingForMovie(int userRatingForMovie) {
        this.userRatingForMovie = userRatingForMovie;
    }

    public Integer getMovieAverage() {
        return movieAverageRating;
    }

    public void setMovieAverage(Integer movieAverage) {
        this.movieAverageRating = movieAverage;
    }
}
