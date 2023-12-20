package com.ahmed.spring_data_jpa.dto;

import com.ahmed.spring_data_jpa.entity.Department;
import com.ahmed.spring_data_jpa.entity.User;
import jakarta.persistence.*;

public class EmployeeDto {


    private Long id;


    private String name;


    private Integer age;


    private Double salary;


    private Long user_id;


    private Long department_id;

    public EmployeeDto() {}

    public EmployeeDto(Long id, String name, Integer age, Double salary, Long user_id, Long department_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.user_id = user_id;
        this.department_id = department_id;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Long department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", user_id=" + user_id +
                ", department_id=" + department_id +
                '}';
    }
}
