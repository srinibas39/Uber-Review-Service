package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    //complex queries
    //usign JPS
    Optional<Driver> findByIdAndAndCarLisence(Long id, String carLisence);

    //using native sql
    @Query(nativeQuery = true, value = "SELECT * FROM driver WHERE id = :id AND car_lisence = :car_lisence")
    Optional<Driver> rawFindByIdAndCarLisence(@Param("id") Long id, @Param("car_lisence") String carLisence);

    //using hibernate
    @Query("SELECT d FROM Driver d WHERE d.id = :id AND d.carLisence = :carLisence")
    Optional<Driver> hibernateFindByIdAndCarLisence(@Param("id") Long id, @Param("carLisence") String carLisence);

}
