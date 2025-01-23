package com.example.employeeperformance.controller;

import com.example.employeeperformance.model.Employee;
import com.example.employeeperformance.model.RatingCategory;
import com.example.employeeperformance.service.EmployeeService;
import com.example.employeeperformance.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PerformanceService performanceService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/percentages")
    public Map<RatingCategory, Double> getActualPercentages() {
        return performanceService.calculateActualPercentages();
    }

    @GetMapping("/deviations")
    public Map<RatingCategory, Double> getDeviations() {
        return performanceService.calculateDeviations();
    }

    @GetMapping("/suggestions")
    public List<Employee> getSuggestions() {
        return performanceService.suggestRevisions();
    }
}