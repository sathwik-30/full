package com.company.procurepulse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "emp_code"),
           @UniqueConstraint(columnNames = "email")
       })
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "emp_code", nullable = false, length = 20)
    private String empCode;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "email", nullable = false, length = 120)
    private String email;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;


    public Employee() {
    }

    public Employee(String empCode, String name, String email, Department department) {
        this.empCode = empCode;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
