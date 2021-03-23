package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@ApiModel(description = "Review details")
@Entity
public class Review implements Serializable {

    @ApiModelProperty(notes="Review id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    @ApiModelProperty(notes="Review title")
    private String reviewTitle;
    @ApiModelProperty(notes="Movie id")
    private String movieId;
    @ApiModelProperty(notes="Movie title")
    private String movieTitle;
    @ApiModelProperty(notes = "Movie year")
    private String movieYear;
    @ApiModelProperty(notes="Review")
    private String reviewText;
    @ApiModelProperty(notes="User's rating for movie")
    private int movieRating;
    @ApiModelProperty(notes="Author of the review")
    private String author;

    public Review() {
    }

    public Review(Long reviewId, String reviewTitle, String movieId, String movieTitle, String movieYear,
                  String reviewText, int movieRating, String author) {
        this.reviewId = reviewId;
        this.reviewTitle = reviewTitle;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
        this.reviewText = reviewText;
        this.movieRating = movieRating;
        this.author = author;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
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

    public String getMovieYear() { return movieYear; }

    public void setMovieYear(String movieYear) { this.movieYear = movieYear; }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(int movieRating) {
        this.movieRating = movieRating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
