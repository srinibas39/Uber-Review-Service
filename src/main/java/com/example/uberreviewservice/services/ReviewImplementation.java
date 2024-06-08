package com.example.uberreviewservice.services;

import com.example.uberreviewservice.repositories.ReviewRepository;

import java.util.List;

public class ReviewImplementation implements Review{

    private ReviewRepository  reviewRepository;

    public ReviewImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;;
    }

    @Override
    public Review findReviewById(Long id) {
        return null;
    }

    @Override
    public List<Review> finaAllReviews() {
        return List.of();
    }

    @Override
    public Review deleteReviewbyId(Long id) {
        return null;
    }
}
