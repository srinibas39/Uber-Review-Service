package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    //complex queries

    Optional<Driver> findByIdAndAndCarLisence(Long id, String carLisence);
}
