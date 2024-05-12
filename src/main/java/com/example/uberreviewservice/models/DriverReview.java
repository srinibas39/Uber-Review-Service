package com.example.uberreviewservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "reviewId")
public class DriverReview extends Review {

    @Column(nullable = false)
    private String driverComment;

    @Column(nullable = false)
    private String driverRating;
}
