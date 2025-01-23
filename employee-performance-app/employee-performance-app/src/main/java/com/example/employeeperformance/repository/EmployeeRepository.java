package com.example.employeeperformance.repository;

import com.example.employeeperformance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}