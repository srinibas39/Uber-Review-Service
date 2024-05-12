package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "passengerId")
public class PassengerReview extends Review {

    @Column(nullable = false)
    private String passengerComment;

    @Column(nullable = false)
    private String passengerRating;

}
