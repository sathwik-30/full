package com.entity;
import java.sql.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "safetyincident")
public class safetyincident {
	  @Id
	    private int incidentId;
	    private int MineId;
	    private Integer equipmentId;
	    private Integer workerId;
	    private Date incidentDate;
	    private String type;
	    private int severity;
	    private double cost;
	    private String status;

	    public int getIncidentId() {
	        return incidentId;
	    }

	    public void setIncidentId(int incidentId) {
	        this.incidentId = incidentId;
	    }

	    public int getMineId() {
	        return MineId;
	    }

	    public void setMineId(int MineId) {
	        this.MineId = MineId;
	    }

	    public Integer getEquipmentId() {
	        return equipmentId;
	    }

	    public void setEquipmentId(Integer equipmentId) {
	        this.equipmentId = equipmentId;
	    }

	    public Integer getWorkerId() {
	        return workerId;
	    }

	    public void setWorkerId(Integer workerId) {
	        this.workerId = workerId;
	    }

	    public Date getIncidentDate() {
	        return incidentDate;
	    }

	    public void setIncidentDate(Date incidentDate) {
	        this.incidentDate = incidentDate;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public int getSeverity() {
	        return severity;
	    }

	    public void setSeverity(int severity) {
	        this.severity = severity;
	    }

	    public double getCost() {
	        return cost;
	    }

	    public void setCost(double cost) {
	        this.cost = cost;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
