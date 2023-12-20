package com.ahmed.spring_data_jpa.service;

import com.ahmed.spring_data_jpa.projection.EmployeeStatisticsProjection;
import com.ahmed.spring_data_jpa.dto.EmployeeDto;
import com.ahmed.spring_data_jpa.entity.Employee;
import com.ahmed.spring_data_jpa.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto fetchEmployeeById(Long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow();
        return new EmployeeDto(emp.getId(),
                emp.getName(),
                emp.getAge(),
                emp.getSalary(),
                emp.getUser().getId(),
                emp.getDepartment().getId());
    }

    public List<EmployeeDto> fetchEmployees() {
        return employeeRepository.findAll()
                .stream().map(employee -> {
                    return new EmployeeDto(employee.getId(),
                            employee.getName(),
                            employee.getAge(),
                            employee.getSalary(),
                            employee.getUser().getId(),
                            employee.getDepartment().getId());
                }).toList();
    }

    public List<Employee> filterEmployeesByName(String name) {
        return employeeRepository.filter(name);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeDto> fetchEmployeesBySalary(Double salary) {
        return employeeRepository.findBySalary(salary).stream()
                .map(employee -> {
                    return new EmployeeDto(employee.getId(),
                            employee.getName(),
                            employee.getAge(),
                            employee.getSalary(),
                            employee.getUser().getId(),
                            employee.getDepartment().getId());
                }).toList();
    }

    public EmployeeStatisticsProjection getStatistics() {
        return employeeRepository.getEmployeeStatistics();
    }
}
