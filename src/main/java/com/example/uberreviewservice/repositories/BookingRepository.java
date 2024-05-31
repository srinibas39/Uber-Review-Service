package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByDriver_Id(Long id);

    List<Booking> findAllByDriverIn(List<Driver> drivers);

    List<Booking> findAllByDriver_Id(Long id);
}
