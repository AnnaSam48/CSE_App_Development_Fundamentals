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
    private Long reviewID;
    @ApiModelProperty(notes="Review title")
    private String reviewTitle;
    @ApiModelProperty(notes="Movie id")
    private String movieId;
    @ApiModelProperty(notes="Movie title")
    private String movieTitle;
    @ApiModelProperty(notes="Review")
    private String reviewText;
    @ApiModelProperty(notes="User's rating for movie")
    private int movieRating;
    @ApiModelProperty(notes="Author of the review")
    private String author;
    @ApiModelProperty(notes="Movie rating (average from all given ratings for this movie)")
    private Integer movieAverageRating;

    public Review() {
    }

    public Review(Long reviewID, String reviewTitle, String movieId, String movieTitle, String reviewText,
                  int movieRating, String author, Integer movieAverageRating) {
        this.reviewID = reviewID;
        this.reviewTitle = reviewTitle;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.reviewText = reviewText;
        this.movieRating = movieRating;
        this.author = author;
        this.movieAverageRating = movieAverageRating;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
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

    public Integer getMovieAverageRating() {
        return movieAverageRating;
    }

    public void setMovieAverageRating(Integer movieAverageRating) {
        this.movieAverageRating = movieAverageRating;
    }
}
