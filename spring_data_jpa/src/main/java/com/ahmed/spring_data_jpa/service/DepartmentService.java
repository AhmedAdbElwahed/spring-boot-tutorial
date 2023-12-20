package com.ahmed.spring_data_jpa.service;

import com.ahmed.spring_data_jpa.entity.Department;
import com.ahmed.spring_data_jpa.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> fetchDepartments() {
        return departmentRepository.findAll();
    }
    
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
