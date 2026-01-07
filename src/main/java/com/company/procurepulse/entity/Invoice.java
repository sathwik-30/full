package com.company.procurepulse.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "invoices",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "invoice_no")
       })
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_no", nullable = false, length = 30)
    private String invoiceNo;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private Employee createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approved_by")
    private Employee approvedBy;

    @OneToMany(mappedBy = "invoice",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<InvoiceLine> lines = new ArrayList<>();

    /* =======================
       Invoice fields
       ======================= */

    @Column(name = "amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal amount;

    @Column(name = "tax_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal taxAmount;

    @Column(name = "invoice_date", nullable = false)
    private LocalDate invoiceDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "submitted_on")
    private LocalDateTime submittedOn;

    @Column(name = "approved_on")
    private LocalDateTime approvedOn;

    @Column(name = "reject_reason", length = 255)
    private String rejectReason;


    @Version
    @Column(name = "version", nullable = false)
    private Long version;


    public Invoice() {
    }

    public Invoice(String invoiceNo, Vendor vendor, Department department,
                   Employee createdBy, LocalDate invoiceDate,
                   LocalDate dueDate) {
        this.invoiceNo = invoiceNo;
        this.vendor = vendor;
        this.department = department;
        this.createdBy = createdBy;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.status = "DRAFT";
        this.amount = BigDecimal.ZERO;
        this.taxAmount = BigDecimal.ZERO;
    }

    /* =======================
       Helper methods
       ======================= */

    public void addLine(InvoiceLine line) {
        lines.add(line);
        line.setInvoice(this);
    }

    public void removeLine(InvoiceLine line) {
        lines.remove(line);
        line.setInvoice(null);
    }


    public Long getId() {
        return id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(LocalDateTime submittedOn) {
        this.submittedOn = submittedOn;
    }

    public LocalDateTime getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(LocalDateTime approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Long getVersion() {
        return version;
    }
}
