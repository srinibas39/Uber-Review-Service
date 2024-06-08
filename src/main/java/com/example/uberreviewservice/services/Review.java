package com.example.uberreviewservice.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Review {

    public Review findReviewById(Long id);

    public List<Review> finaAllReviews();

    public Review deleteReviewbyId(Long id);

}
