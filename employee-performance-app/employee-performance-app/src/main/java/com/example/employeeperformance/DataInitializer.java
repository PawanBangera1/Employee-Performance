package com.example.employeeperformance;

import com.example.employeeperformance.model.Employee;
import com.example.employeeperformance.model.RatingCategory;
import com.example.employeeperformance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.saveAll(Arrays.asList(
            new Employee(null, "Harry", RatingCategory.A),
            new Employee(null, "Harry", RatingCategory.B),
            new Employee(null, "Harry", RatingCategory.C),
            new Employee(null, "Harry", RatingCategory.D),
            new Employee(null, "Harry", RatingCategory.E),
            new Employee(null, "Harry", RatingCategory.A),
            new Employee(null, "Harry", RatingCategory.C),
            new Employee(null, "Harry", RatingCategory.D),
            new Employee(null, "Harry", RatingCategory.B),
            new Employee(null, "Harry", RatingCategory.E),
            new Employee(null, "Harry", RatingCategory.A),
            new Employee(null, "Harry", RatingCategory.C),
            new Employee(null, "Harry", RatingCategory.D),
            new Employee(null, "Harry", RatingCategory.C),
            new Employee(null, "Harry", RatingCategory.E)
        ));
    }
}