package com.entity;
import java.sql.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "shiftlog")
public class shiftlog {

    @Id
    private int shiftId;
    private int MineId;
    private Date shiftDate;
    private String shiftType;
    private int supervisorId;

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getMineId() {
        return MineId;
    }

    public void setMineId(int MineId) {
        this.MineId = MineId;
    }

    public Date getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        this.shiftDate = shiftDate;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }
}
