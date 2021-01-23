package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,String> {

    List<Movie> findAll();
    Movie findByImdbId(String id);
}
