package com.example.employeeperformance.service;

import com.example.employeeperformance.model.Employee;
import com.example.employeeperformance.model.RatingCategory;
import com.example.employeeperformance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PerformanceService {
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Map<RatingCategory, Double> STANDARD_PERCENTAGES = Map.of(
        RatingCategory.A, 10.0,
        RatingCategory.B, 20.0,
        RatingCategory.C, 40.0,
        RatingCategory.D, 20.0,
        RatingCategory.E, 10.0
    );

    public Map<RatingCategory, Double> calculateActualPercentages() {
        List<Employee> employees = employeeRepository.findAll();
        int totalEmployees = employees.size();

        Map<RatingCategory, Long> countByCategory = employees.stream()
            .collect(Collectors.groupingBy(Employee::getRating, Collectors.counting()));

        Map<RatingCategory, Double> actualPercentages = new HashMap<>();
        for (RatingCategory category : RatingCategory.values()) {
            actualPercentages.put(category, (countByCategory.getOrDefault(category, 0L) * 100.0) / totalEmployees);
        }

        return actualPercentages;
    }

    public Map<RatingCategory, Double> calculateDeviations() {
        Map<RatingCategory, Double> actualPercentages = calculateActualPercentages();
        Map<RatingCategory, Double> deviations = new HashMap<>();

        for (RatingCategory category : RatingCategory.values()) {
            double deviation = actualPercentages.get(category) - STANDARD_PERCENTAGES.get(category);
            deviations.put(category, deviation);
        }

        return deviations;
    }

    public List<Employee> suggestRevisions() {
        Map<RatingCategory, Double> deviations = calculateDeviations();
        List<Employee> employees = employeeRepository.findAll();

        List<Employee> suggestedRevisions = new ArrayList<>();
        for (Employee employee : employees) {
            RatingCategory rating = employee.getRating();
            if (deviations.get(rating) > 0) {
                suggestedRevisions.add(employee);
            }
        }

        return suggestedRevisions;
    }
}