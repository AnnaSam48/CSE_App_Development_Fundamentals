package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAll();
    List<Review> findAllByMovieTitle(String movieTitle);
    Optional<Review> findByReview(Long reviewId);

}
