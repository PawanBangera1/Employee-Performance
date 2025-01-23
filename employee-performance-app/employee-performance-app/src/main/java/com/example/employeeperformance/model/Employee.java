package com.example.employeeperformance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private RatingCategory rating;

    // Default constructor
    public Employee() {
    }

    // Constructor with parameters
    public Employee(Long id, String name, RatingCategory rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RatingCategory getRating() {
        return rating;
    }

    public void setRating(RatingCategory rating) {
        this.rating = rating;
    }
}