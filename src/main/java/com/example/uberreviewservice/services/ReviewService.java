package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.ReviewModel;
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
        ReviewModel r = ReviewModel.builder().content("Excellent Ride").Rating(4.0).build();
        System.out.println(r);
        reviewRepositories.save(r);

        List<ReviewModel>  reviewList = reviewRepositories.findAll();

        for(ReviewModel review : reviewList){
            System.out.println(review.getContent());
            System.out.println(review.getRating());
        }

    }
}