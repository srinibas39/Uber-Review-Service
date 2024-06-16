package com.example.uberreviewservice.adapters;

import com.example.uberreviewservice.dtos.CreateReviewDto;
import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewToReviewAdapterImplementation implements CreateReviewToReviewAdapter {

    private BookingRepository bookingRepository;

    public CreateReviewToReviewAdapterImplementation(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {

        Long bookingId = createReviewDto.getBooking();
        Optional<Booking> booking = this.bookingRepository.findById(bookingId);
        return booking.map(value -> Review.builder()
                .rating(createReviewDto.getRating())
                .booking(value)
                .content(createReviewDto.getContent())
                .build()).orElse(null);


    }
}
