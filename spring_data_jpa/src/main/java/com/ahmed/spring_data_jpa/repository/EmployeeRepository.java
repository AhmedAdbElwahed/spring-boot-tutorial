package com.ahmed.spring_data_jpa.repository;

import com.ahmed.spring_data_jpa.projection.EmployeeStatisticsProjection;
import com.ahmed.spring_data_jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // It is used instead of the @NamedNativeQuery for readability purpose
    @Query("select emp from #{#entityName} emp where emp.name = :empName")
    List<Employee> filter(@Param("empName") String empName);

    List<Employee> findBySalary(Double salary);

    @Query(value = """
            select
            (select count(*) from employee) employeesCount,
            (select count(*) from security_user) usersCount,
            (select count(*) from department) departmentsCount
            """, nativeQuery = true)
    EmployeeStatisticsProjection getEmployeeStatistics();
}
