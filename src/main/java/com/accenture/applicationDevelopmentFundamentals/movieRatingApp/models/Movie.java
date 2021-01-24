package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@ApiModel(description = "Basic movie details returned from OMDB API")
@Entity
public class Movie implements Serializable {

    @ApiModelProperty(notes = "Internet Movie Database (IMDb) id")
    @Id
    @Column(length = 12)
    private String imdbId;
    @ApiModelProperty(notes="Movie title")
    @Column
    private String Title;
    @ApiModelProperty(notes="Year")
    @Column
    private String Year;
    @ApiModelProperty(notes="Movie genre/-s")
    @Column
    private String Genre;
    @ApiModelProperty(notes="Movie director")
    @Column
    private String Director;
    @ApiModelProperty(notes="Cast")
    @Column
    private String Actors;


    public Movie() {
    }

    public Movie(String imdbId, String title, String year, String genre, String director, String actors) {
        this.imdbId = imdbId;
        Title = title;
        Year = year;
        Genre = genre;
        Director = director;
        Actors = actors;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

}
