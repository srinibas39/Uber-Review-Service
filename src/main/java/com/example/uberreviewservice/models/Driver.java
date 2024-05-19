package com.example.uberreviewservice.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Driver extends BaseModel {

    private String name;

    @Column(unique = true)
    private String carLisence;

    //one to many relationship
    //A driver can have many bookings

    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

}
