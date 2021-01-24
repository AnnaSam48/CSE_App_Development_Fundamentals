package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    String averageRatingValue = "SELECT AVG(r.userRatingForMovie) FROM Review r WHERE r.movieId = :movieId";

    @Query(averageRatingValue)
    Integer average(@Param(value = "movieId") String movieId);

    List<Review> findAll();
    List<Review> findAllByMovieTitle(String movieTitle);

}
