package com.example.employeeperformance;

import com.example.employeeperformance.model.Employee;
import com.example.employeeperformance.model.RatingCategory;
import com.example.employeeperformance.repository.EmployeeRepository;
import com.example.employeeperformance.service.PerformanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PerformanceServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private PerformanceService performanceService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateActualPercentages() {
        List<Employee> employees = Arrays.asList(
            new Employee(1L, "Harry", RatingCategory.A),
            new Employee(2L, "Harry", RatingCategory.B),
            new Employee(3L, "Harry", RatingCategory.C),
            new Employee(4L, "Harry", RatingCategory.D),
            new Employee(5L, "Harry", RatingCategory.E)
        );

        when(employeeRepository.findAll()).thenReturn(employees);

        Map<RatingCategory, Double> actualPercentages = performanceService.calculateActualPercentages();

        assertEquals(20.0, actualPercentages.get(RatingCategory.A));
        assertEquals(20.0, actualPercentages.get(RatingCategory.B));
        assertEquals(20.0, actualPercentages.get(RatingCategory.C));
        assertEquals(20.0, actualPercentages.get(RatingCategory.D));
        assertEquals(20.0, actualPercentages.get(RatingCategory.E));
    }

    @Test
    public void testCalculateDeviations() {
        List<Employee> employees = Arrays.asList(
            new Employee(1L, "Harry", RatingCategory.A),
            new Employee(2L, "Harry", RatingCategory.B),
            new Employee(3L, "Harry", RatingCategory.C),
            new Employee(4L, "Harry", RatingCategory.D),
            new Employee(5L, "Harry", RatingCategory.E)
        );

        when(employeeRepository.findAll()).thenReturn(employees);

        Map<RatingCategory, Double> deviations = performanceService.calculateDeviations();

        assertEquals(10.0, deviations.get(RatingCategory.A));
        assertEquals(0.0, deviations.get(RatingCategory.B));
        assertEquals(-20.0, deviations.get(RatingCategory.C));
        assertEquals(0.0, deviations.get(RatingCategory.D));
        assertEquals(10.0, deviations.get(RatingCategory.E));
    }

    @Test
    public void testSuggestRevisions() {
        List<Employee> employees = Arrays.asList(
            new Employee(1L, "Harry", RatingCategory.A),
            new Employee(2L, "Harry", RatingCategory.B),
            new Employee(3L, "Harry", RatingCategory.C),
            new Employee(4L, "Harry", RatingCategory.D),
            new Employee(5L, "Harry", RatingCategory.E)
        );

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> suggestedRevisions = performanceService.suggestRevisions();

        assertEquals(2, suggestedRevisions.size());
        assertEquals(RatingCategory.A, suggestedRevisions.get(0).getRating());
        assertEquals(RatingCategory.E, suggestedRevisions.get(1).getRating());
    }
}