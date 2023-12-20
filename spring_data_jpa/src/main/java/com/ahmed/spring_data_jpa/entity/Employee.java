package com.ahmed.spring_data_jpa.entity;

import jakarta.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "EmployeeMapping",
        entities = @EntityResult(
                entityClass = Employee.class,
                fields = {
                        @FieldResult(name = "id", column = "emp_id"),
                        @FieldResult(name = "name", column = "emp_name"),
                        @FieldResult(name = "salary", column = "emp_salary"),
                        @FieldResult(name = "age", column = "emp_age")
                }
        )
)
@NamedNativeQuery(name = "Employee.findBySalary"
        , query = """
select * from employee emp where emp.emp_salary =:salary
""",
resultSetMapping = "EmployeeMapping")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_age")
    private Integer age;

    @Column(name = "emp_salary")
    private Double salary;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    public Employee() {
    }

    public Employee(
            Long id, String name, Integer age,
            Double salary, Department department, User user) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.user = user;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", user=" + user +
                ", department=" + department +
                '}';
    }
}
