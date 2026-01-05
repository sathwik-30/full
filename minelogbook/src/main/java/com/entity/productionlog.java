package com.entity;
import java.sql.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "productionlog")
public class productionlog {
    @Id
    private int prodId;
    private int MineId;
    private Integer shiftId;
    private Date logDate;
    private double tonnes;
    private double grade;

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getMineId() {
        return MineId;
    }

    public void setMineId(int MineId) {
        this.MineId = MineId;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
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
