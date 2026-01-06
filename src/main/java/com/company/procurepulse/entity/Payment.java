package com.company.procurepulse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* =======================
       Relationship
       ======================= */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;

    /* =======================
       Payment fields
       ======================= */

    @Column(name = "paid_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal paidAmount;

    @Column(name = "paid_on", nullable = false)
    private LocalDateTime paidOn;

    @Column(name = "mode", nullable = false, length = 30)
    private String mode;

    @Column(name = "reference_no", length = 60)
    private String referenceNo;

    /* =======================
       Constructors
       ======================= */

    public Payment() {
    }

    public Payment(Invoice invoice, BigDecimal paidAmount,
                   String mode, String referenceNo) {
        this.invoice = invoice;
        this.paidAmount = paidAmount;
        this.mode = mode;
        this.referenceNo = referenceNo;
        this.paidOn = LocalDateTime.now();
    }

    /* =======================
       Getters & Setters
       ======================= */

    public Long getId() {
        return id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LocalDateTime getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(LocalDateTime paidOn) {
        this.paidOn = paidOn;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }
}
