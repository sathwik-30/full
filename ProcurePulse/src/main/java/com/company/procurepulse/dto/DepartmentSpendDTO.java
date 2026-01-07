package com.company.procurepulse.dto;

import java.math.BigDecimal;

public class DepartmentSpendDTO {

    private String deptCode;
    private BigDecimal totalSpend;

    public DepartmentSpendDTO(String deptCode, BigDecimal totalSpend) {
        this.deptCode = deptCode;
        this.totalSpend = totalSpend;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public BigDecimal getTotalSpend() {
        return totalSpend;
    }
}
