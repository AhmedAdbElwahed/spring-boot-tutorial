package com.ahmed.spring_data_jpa.controller;

import com.ahmed.spring_data_jpa.projection.EmployeeStatisticsProjection;
import com.ahmed.spring_data_jpa.dto.EmployeeDto;
import com.ahmed.spring_data_jpa.entity.Employee;
import com.ahmed.spring_data_jpa.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<EmployeeDto> fetchEmployees() {
        return employeeService.fetchEmployees();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto fetchEmployeeById(@PathVariable(name = "id") Long id) {
        return employeeService.fetchEmployeeById(id);
    }

    @GetMapping("/employee/filter/{name}")
    public List<Employee> filterEmployeeByName(@PathVariable(name = "name") String name) {
        return employeeService.filterEmployeesByName(name);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employee/salary")
    public List<EmployeeDto> filterEmployeesBySalary(@RequestParam Double salary) {
        return employeeService.fetchEmployeesBySalary(salary);
    }

    @GetMapping("/statistics")
    public EmployeeStatisticsProjection fetchStatistics() {
        return employeeService.getStatistics();
    }


}
