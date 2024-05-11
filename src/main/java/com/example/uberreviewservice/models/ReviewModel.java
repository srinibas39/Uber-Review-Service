package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Builder // need builder to build the records
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="bookingReview") // name of the table
public class ReviewModel {

    @Id //making id as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    Long id;

    @Column(nullable = false)
    private String content;

    private Double Rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @CreatedDate //timeestamp of created object
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //timestamp of updated Object
    private Date updatedAt;

}
