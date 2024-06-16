package com.example.uberreviewservice.controllers;


import com.example.uberreviewservice.adapters.CreateReviewToReviewAdapter;
import com.example.uberreviewservice.dtos.CreateReviewDto;
import com.example.uberreviewservice.dtos.ResponseReviewDto;
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

    private CreateReviewToReviewAdapter createReviewToReviewAdapter;

    public ReviewController(ReviewService reviewService , CreateReviewToReviewAdapter createReviewToReviewAdapter){
        this.reviewService = reviewService;
        this.createReviewToReviewAdapter = createReviewToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@RequestBody CreateReviewDto request){
        Review incomingReview = createReviewToReviewAdapter.convertDto(request);
        if(incomingReview == null){
            return new ResponseEntity<>("invalid arguments",HttpStatus.BAD_REQUEST);
        }
        else{
            Review review = this.reviewService.publishReview(incomingReview);
            ResponseReviewDto resp = ResponseReviewDto.builder()
                    .rating(review.getRating())
                    .createdAt(review.getCreatedAt())
                    .updatedAt(review.getUpdatedAt())
                    .content(review.getContent())
                    .booking(review.getBooking().getId())
                    .id(review.getId()).build();
            return new ResponseEntity<>(resp,HttpStatus.CREATED);

        }
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
