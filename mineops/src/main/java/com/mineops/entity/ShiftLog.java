package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ShiftLog")
public class ShiftLog {

    @Id
    private int shiftId;

    private int mineId;
    private String shiftDate;
    private String shiftType;   // DAY / NIGHT
    private int supervisorId;   // workerId reference

    public ShiftLog() {}

    public int getShiftId() {
        return shiftId;
    }

    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
    }

    public String getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(String shiftDate) {
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

    @Override
    public String toString() {
        return "ShiftLog [shiftId=" + shiftId + ", mineId=" + mineId + 
               ", shiftDate=" + shiftDate + ", shiftType=" + shiftType +
               ", supervisorId=" + supervisorId + "]";
    }
}
