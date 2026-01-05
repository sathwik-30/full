package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SafetyIncident")
public class SafetyIncident {

    @Id
    private int incidentId;

    private int mineId;
    private Integer equipmentId; // nullable
    private Integer workerId;    // nullable
    private String incidentDate;
    private String type;
    private int severity;        // 1 to 5
    private double cost;
    private String status;       // OPEN / CLOSED

    public SafetyIncident() {}

    public int getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
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

    public String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(String incidentDate) {
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

    @Override
    public String toString() {
        return "SafetyIncident [incidentId=" + incidentId + ", mineId=" + mineId +
               ", equipmentId=" + equipmentId + ", workerId=" + workerId +
               ", incidentDate=" + incidentDate + ", type=" + type +
               ", severity=" + severity + ", cost=" + cost + ", status=" + status + "]";
    }
}
