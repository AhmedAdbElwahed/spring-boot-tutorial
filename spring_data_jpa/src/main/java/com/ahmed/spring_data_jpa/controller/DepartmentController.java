package com.ahmed.spring_data_jpa.controller;

import com.ahmed.spring_data_jpa.entity.Department;
import com.ahmed.spring_data_jpa.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department")
    public List<Department> fetchDepartments() {
        return departmentService.fetchDepartments();
    }

    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }


}
