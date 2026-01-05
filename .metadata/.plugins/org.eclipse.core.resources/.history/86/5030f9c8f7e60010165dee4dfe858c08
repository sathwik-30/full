package com.entity;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "equipmentusage")
public class equipmentusage {
	   @Id
	    private int usageId;

	    private int MineId;
	    private int equipmentId;
	    private Date usageDate;
	    private double runningHours;

	    // FIXED: was String, now char to match CHAR(1)
	    private char breakdown;

	    private double downtimeHours;

	    public int getUsageId() {
	        return usageId;
	    }

	    public void setUsageId(int usageId) {
	        this.usageId = usageId;
	    }

	    public int getMineId() {
	        return MineId;
	    }

	    public void setMineId(int MineId) {
	        this.MineId = MineId;
	    }

	    public int getEquipmentId() {
	        return equipmentId;
	    }

	    public void setEquipmentId(int equipmentId) {
	        this.equipmentId = equipmentId;
	    }

	    public Date getUsageDate() {
	        return usageDate;
	    }

	    public void setUsageDate(Date usageDate) {
	        this.usageDate = usageDate;
	    }

	    public double getRunningHours() {
	        return runningHours;
	    }

	    public void setRunningHours(double runningHours) {
	        this.runningHours = runningHours;
	    }

	    public char getBreakdown() {
	        return breakdown;
	    }

	    public void setBreakdown(char breakdown) {
	        this.breakdown = breakdown;
	    }

	    public double getDowntimeHours() {
	        return downtimeHours;
	    }

	    public void setDowntimeHours(double downtimeHours) {
	        this.downtimeHours = downtimeHours;
	    }
	}

