package com.mineops.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MineSite")
public class MineSite {

    @Id
    private int mineId;

    private String name;
    private String location;
    private String status;  // ACTIVE / INACTIVE

    public MineSite() {}

    public int getMineId() 
    {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MineSite [mineId=" + mineId + ", name=" + name + 
               ", location=" + location + ", status=" + status + "]";
    }
}
