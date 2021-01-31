package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    String SEARCHBYMOVIETITLE =
            "SELECT r FROM Review r JOIN Movie m ON r.movieID = m.imdbID WHERE m.Title LIKE %:movieTitle%";

    List<Review> findAllByMovieId(String movieId);
    List<Review> findAll();

    @Query(SEARCHBYMOVIETITLE)
    List<Review> findByMovieTitle(@Param(value = "movieTitle") String movieTitle);
}
