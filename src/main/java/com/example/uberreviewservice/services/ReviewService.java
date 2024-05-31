package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.*;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import jakarta.persistence.Inheritance;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
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

//       Optional<Driver> driver = driverRepositories.hibernateFindByIdAndCarLisence(1L,"ABCD");
//       if(driver.isPresent()){
//           String driverName = driver.get().getName();
//           System.out.println(driverName);
//
//           List<Booking> bookings = bookingRepositories.findByDriver_Id(1L);
//
//
//           for(Booking booking : bookings){
//               System.out.println(booking.getBookingStatus());
//           }
//
//
//       }

        //fetch Type --> eager , lazy

//        Optional<Driver> drivers = driverRepositories.findById(1L);
//        if(drivers.isPresent()){
//            Driver driver = drivers.get();
//            String liscence = driver.getCarLisence();
//            System.out.println(liscence);
//        }

        //Custom Driver

//        Optional<CustomDriver> drivers = driverRepositories.hibernateFindById(2L);
//
//       if(drivers.isPresent()){
//           String driverName = drivers.get().getName();
//           System.out.println("hello "+driverName);
//       }

        List<Long> ids = new ArrayList<>(Arrays.asList(1L,2l,3l,4L,5L,6L,7L,8L,9L));
        List<Driver> drivers = driverRepositories.findAllByIdIn(ids);

//        List<Booking> bookings = bookingRepositories.findAllByDriverIn(drivers);
//
//        for(Booking booking : bookings){
//            System.out.println(booking.getId());
//        }

        for(Driver driver : drivers){
            List<Booking> bookings = driver.getBookings();
//            for(Booking booking : bookings){
//                System.out.print(booking.getId()+" ");
//            }
            bookings.forEach(booking -> System.out.print(booking.getId()+" "));
     System.out.println("");
        }





    }
}
