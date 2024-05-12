package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    //do dependecies injection for repositories
    private ReviewRepository reviewRepositories;

    public ReviewService(ReviewRepository reviewRepositories){
        this.reviewRepositories = reviewRepositories;
    }

    //do depe
    @Override
    public void run(String... args) throws Exception {
        System.out.println("****************");
        Review r = Review.builder().content("Excellent Ride").Rating(4.0).build();
        System.out.println(r);
        reviewRepositories.save(r);

        List<Review>  reviewList = reviewRepositories.findAll();

        for(Review review : reviewList){
            System.out.println(review.getContent());
            System.out.println(review.getRating());
        }

    }
}
