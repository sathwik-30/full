package com.company.procurepulse.dto;

import java.math.BigDecimal;

public class AgingBucketDTO {

    private String bucket;
    private Long invoiceCount;
    private BigDecimal totalAmount;

    public AgingBucketDTO(String bucket, Long invoiceCount, BigDecimal totalAmount) {
        this.bucket = bucket;
        this.invoiceCount = invoiceCount;
        this.totalAmount = totalAmount;
    }

    public String getBucket() {
        return bucket;
    }

    public Long getInvoiceCount() {
        return invoiceCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
}
