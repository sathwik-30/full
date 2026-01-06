package com.company.procurepulse.dto;

import java.math.BigDecimal;

public class VendorSpendDTO {

    private String vendorCode;
    private BigDecimal totalSpend;

    public VendorSpendDTO(String vendorCode, BigDecimal totalSpend) {
        this.vendorCode = vendorCode;
        this.totalSpend = totalSpend;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public BigDecimal getTotalSpend() {
        return totalSpend;
    }
}
