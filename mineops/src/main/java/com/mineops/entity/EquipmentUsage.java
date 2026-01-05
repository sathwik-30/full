package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EquipmentUsage")
public class EquipmentUsage {

    @Id
    private int usageId;

    private int mineId;
    private int equipmentId;
    private String usageDate;
    private double runningHours;
    private String breakdown;     // Y/N
    private double downtimeHours;

    public EquipmentUsage() {}

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

    public String getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(String usageDate) {
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
        return downtimeHo
