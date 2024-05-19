package com.example.uberreviewservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Course extends BaseModel {

    private String name;
    private String description;

    @ManyToMany
    private List<Student> studentList = new ArrayList<>();
}
