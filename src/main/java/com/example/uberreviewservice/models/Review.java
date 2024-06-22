package com.example.uberreviewservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder // need builder to build the records
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="bookingReview") // name of the table
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"booking"})
public class Review extends BaseModel {

//    @Id //making id as primary key
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
//    Long id;

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Booking booking;


    public void updateFrom(Review review){
        this.content = review.getContent();
        this.booking = review.getBooking();
        this.rating = review.getRating();
    }

}
