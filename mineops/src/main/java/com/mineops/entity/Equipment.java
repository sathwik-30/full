package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Equipment")
public class Equipment {

    @Id
    private int equipmentId;

    private int mineId;
    private String name;
    private String type;
    private String status;        // WORKING / MAINTENANCE / BROKEN
    private String purchaseDate;  // (store as String or use LocalDate later)

    public Equipment() {}

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public int getMineId() {
        return mineId;
    }

    public void setMineId(int mineId) {
        this.mineId = mineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Equipment [equipmentId=" + equipmentId + ", mineId=" + mineId +
                ", name=" + name + ", type=" + type + ", status=" + status +
                ", purchaseDate=" + purchaseDate + "]";
    }
}
