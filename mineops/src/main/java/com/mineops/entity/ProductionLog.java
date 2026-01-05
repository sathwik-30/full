package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductionLog")
public class ProductionLog {

    @Id
    private int prodId;

    private int mineId;
    private Integer shiftId; // optional
    private String logDate;
    private double tonnes;
    private double grade;

    public ProductionLog() {}

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

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
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

    @Override
    public String toString() {
        return "ProductionLog [prodId=" + prodId + ", mineId=" + mineId +
               ", shiftId=" + shiftId + ", logDate=" + logDate +
               ", tonnes=" + tonnes + ", grade=" + grade + "]";
    }
}
