package com.accenture.applicationDevelopmentFundamentals.movieRatingApp.repositories;

import com.accenture.applicationDevelopmentFundamentals.movieRatingApp.models.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    String averageRatingValue = "SELECT AVG(r.value) FROM Rating r WHERE r.reviewId = :reviewID";


    @Query(averageRatingValue)
    int average(@Param(value = "reviewID") Long reviewID);

    List<Rating> findAllByReviewId(Long reviewId);

}
