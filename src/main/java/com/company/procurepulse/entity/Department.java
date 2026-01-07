package com.company.procurepulse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dept_code", nullable = false, unique = true, length = 20)
    private String deptCode;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "yearly_budget", nullable = false, precision = 12, scale = 2)
    private BigDecimal yearlyBudget;

    // ===== Constructors =====
    public Department() {
    }

    public Department(String deptCode, String name, BigDecimal yearlyBudget) {
        this.deptCode = deptCode;
        this.name = name;
        this.yearlyBudget = yearlyBudget;
    }

    public Long getId() {
        return id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getYearlyBudget() {
        return yearlyBudget;
    }

    public void setYearlyBudget(BigDecimal yearlyBudget) {
        this.yearlyBudget = yearlyBudget;
    }
}
