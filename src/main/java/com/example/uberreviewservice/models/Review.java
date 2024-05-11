package com.example.uberreviewservice.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="bookingReview") // name of the table
public class Review {

    @Id //making id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    Long id;

    @Column(nullable = false)
    String content;

    Double Rating;

    @Column(nullable = false)
    Date createdAt;

    @Column(nullable = false)
    Date updatedAt;

}
