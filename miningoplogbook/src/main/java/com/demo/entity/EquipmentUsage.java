package com.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipment_usage")
public class EquipmentUsage {

    @Id
    private int usageId;

    private int mineId;              // foreign key (NO association)
    private int equipmentId;         // foreign key (NO association)

    private LocalDate usageDate;
    private double runningHours;
    private String breakdown;        // Y / N
    private double downtimeHours;

    // -------- Getters and Setters --------

    public int getUsageId() {
        return usageId;
    }

    public void setUsageId(int usageId) {
        this.usageId = usageId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public LocalDate getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(LocalDate usageDate) {
        this.usageDate = usageDate;
    }

    public double getRunningHours() {
        return runningHours;
    }

    public void setRunningHours(double runningHours) {
        this.runningHours = runningHours;
    }

    public String getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(String breakdown) {
        this.breakdown = breakdown;
    }

    public double getDowntimeHours() {
        return downtimeHours;
    }

    public void setDowntimeHours(double downtimeHours) {
        this.downtimeHours = downtimeHours;
    }
}
