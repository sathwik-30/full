package com.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "production_log")
public class ProductionLog {

    @Id
    private int prodId;

    private int mineId;        // just an ID (NO foreign key, NO association)
    private Integer shiftId;   // optional, can be null

    private LocalDate logDate;
    private double tonnes;     // > 0
    private double grade;      // 0 - 100

    // -------- Getters and Setters --------

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }

    public double getTonnes() {
        return tonnes;
    }

    public void setTonnes(double tonnes) {
        this.tonnes = tonnes;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
