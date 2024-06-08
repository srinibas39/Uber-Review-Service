package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {


      Integer countAllByRatingIsLessThanEqual(Double givenRating);

      List<Review> findAllByRatingIsLessThanEqual(Double givenRating);

      List<Review> findAllByCreatedAtBefore(Date date);

      @Query("SELECT r from Booking b inner join Review r where b.id=:bookingId")
      List<Review> findReviewByBookingId(Long bookingId);

      Review deleteReviewById(Long id);

}


