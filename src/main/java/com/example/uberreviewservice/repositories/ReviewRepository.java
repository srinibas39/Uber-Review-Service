package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel,Long> {

    //model and type of primaryid
}
