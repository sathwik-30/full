package com.company.procurepulse.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendors",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "vendor_code")
       })
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vendor_code", nullable = false, length = 20)
    private String vendorCode;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "gstin", length = 20)
    private String gstin;

    @Column(name = "email", length = 120)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "created_on", nullable = false)
    private LocalDate createdOn;

    /* =======================
       Constructors
       ======================= */

    public Vendor() {
    }

    public Vendor(String vendorCode, String name, String gstin,
                  String email, String phone, String status) {
        this.vendorCode = vendorCode;
        this.name = name;
        this.gstin = gstin;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.createdOn = LocalDate.now();
    }

    /* =======================
       Getters & Setters
       ======================= */

    public Long getId() {
        return id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
