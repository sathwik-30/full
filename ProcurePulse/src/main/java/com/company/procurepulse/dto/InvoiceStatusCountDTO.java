package com.company.procurepulse.dto;

public class InvoiceStatusCountDTO {

    private String status;
    private Long count;

    public InvoiceStatusCountDTO(String status, Long count) {
        this.status = status;
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public Long getCount() {
        return count;
    }
}
