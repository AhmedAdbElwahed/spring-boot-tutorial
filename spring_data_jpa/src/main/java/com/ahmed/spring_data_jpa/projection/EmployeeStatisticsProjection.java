package com.ahmed.spring_data_jpa.projection;

public interface EmployeeStatisticsProjection {
    Long getEmployeesCount();
    Long getUsersCount();
    Long getDepartmentsCount();
}
