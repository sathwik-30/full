package com.company.procurepulse.dto;

import java.math.BigDecimal;

public class ApprovedUnpaidDTO {

    private Long invoiceCount;
    private BigDecimal totalAmount;

    public ApprovedUnpaidDTO(Long invoiceCount, BigDecimal totalAmount) {
        this.invoiceCount = invoiceCount;
        this.totalAmount = totalAmount;
    }

    public Long getInvoiceCount() {
        return invoiceCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
