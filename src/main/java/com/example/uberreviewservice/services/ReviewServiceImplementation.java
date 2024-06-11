package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImplementation implements ReviewService{

    ReviewRepository reviewRepository;
    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
         return this.reviewRepository.findById(id);
//        return Optional.empty();
    }

    @Override
    public List<Review> finaAllReviews() {
        return this.reviewRepository.findAll();
    }

    @Override
    public Optional<Review> deleteReviewbyId(Long id) {
         Optional<Review> review = this.reviewRepository.findById(id);
         review.ifPresent(reviewRepository::delete);
         return review;

    }

    @Override
    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> updateReviewById(long id, Review review) {
        return this.reviewRepository.findById(id).map(existingReview -> {
            existingReview.updateFrom(review);
            return this.reviewRepository.save(existingReview);
        });
    }
}
