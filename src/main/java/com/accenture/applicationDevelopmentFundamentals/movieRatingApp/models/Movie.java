package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Basic movie details returned from OMDB API")
@Entity
public class Movie implements Serializable {

    @ApiModelProperty(notes = "Internet Movie Database (IMDb) id")
    @Id
    @Column(length = 12)
    private String imdbID;
    @ApiModelProperty(notes = "Movie title")
    @Column
    private String Title;
    @ApiModelProperty(notes = "Year")
    @Column
    private String Year;

    public Movie() {
    }

    public Movie(String imdbID, String title, String year) {
        this.imdbID = imdbID;
        Title = title;
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    // Year is added for search convenience, when looking for movie, it doesn't need to be set anywhere
    public String getYear() {
        return Year;
    }

}






