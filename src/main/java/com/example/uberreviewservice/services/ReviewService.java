package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.BookingStatus;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    //do dependecies injection for repositories
    private ReviewRepository reviewRepositories;
    private BookingRepository bookingRepositories;
    private DriverRepository driverRepositories;

    public ReviewService(ReviewRepository reviewRepositories,
                         BookingRepository bookingRepositories,
                         DriverRepository driverRepositories){
        this.reviewRepositories = reviewRepositories;
        this.bookingRepositories = bookingRepositories;
        this.driverRepositories = driverRepositories;
    }

    //do depe
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("****************");
//        Review r = Review.builder()
//                .content("Excellent Ride 99")
//                .Rating(5.0)
//                .build();
//        System.out.println(r);
//
//        Booking b = Booking.builder()
//                    .bookingStatus(BookingStatus.ASSIGNING_DRIVER)
//                    .startTime(new Date()).review(r).build();


        //It is having bacause of CASCADE TYPE
//        reviewRepositories.save(r);

//        bookingRepositories.save(b);
//
//
//        List<Review>  reviewList = reviewRepositories.findAll();
//
//        for(Review review : reviewList){
//            System.out.println(review.getContent());
//            System.out.println(review.getRating());
//        }

       Optional<Driver> driver = driverRepositories.hibernateFindByIdAndCarLisence(1L,"ABCD");
       if(driver.isPresent()){
           String driverName = driver.get().getName();
           System.out.println(driverName);

           List<Booking> bookings = bookingRepositories.findByDriver_Id(1L);


           for(Booking booking : bookings){
               System.out.println(booking.getBookingStatus());
           }


       }

        //fetch Type --> eager , lazy

//        Optional<Driver> drivers = driverRepositories.findById(1L);
//        if(drivers.isPresent()){
//            Driver driver = drivers.get();
//            String liscence = driver.getCarLisence();
//            System.out.println(liscence);
//        }


    }
}
