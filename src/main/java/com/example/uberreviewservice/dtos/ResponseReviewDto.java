package com.example.uberreviewservice.dtos;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReviewDto {

    private Long id;
    private String content;
    private Long booking;
    private Double rating;
    private Date createdAt;
    private Date updatedAt;

}
