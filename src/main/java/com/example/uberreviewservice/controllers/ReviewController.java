package com.example.uberreviewservice.controllers;


import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> publishReview(@RequestBody Review request){
       Review review = this.reviewService.publishReview(request);
       return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = this.reviewService.finaAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@Validated @PathVariable long id) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(id);
            if (review.isPresent()) {
                return new ResponseEntity<>(review, HttpStatus.OK); // Return the Review object
            } else {
                return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable long id) {
        try {
            Optional<Review> review = this.reviewService.deleteReviewbyId(id);
            if (review.isPresent()) {
                return new ResponseEntity<>(review, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReviewbuid(@PathVariable long id , @RequestBody Review request){
        try{
            Optional<Review> review = this.reviewService.updateReviewById(id,request);
            if(review.isPresent()){
                return new ResponseEntity<>(review,HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Review could not updated",HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
