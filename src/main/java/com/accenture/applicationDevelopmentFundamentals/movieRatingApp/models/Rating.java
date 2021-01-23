package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {

    @ApiModelProperty(notes="Rating id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ratingid")
    private Long id;
    @ApiModelProperty(notes="Review id")
    private Long reviewId;
    @ApiModelProperty(notes="Given rating")
    private int value;

    public Rating() {

    }

    public Rating(Long id, Long reviewId, int value) {
        this.id = id;
        this.reviewId = reviewId;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
