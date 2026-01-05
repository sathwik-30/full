package com.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "worker")
public class worker {

    @Id
    private int workerId;
    private int MineId;
    private String name;
    private String Role;
    private String Phone;

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public int getMineId() {
        return MineId;
    }

    public void setMineId(int MineId) {
        this.MineId = MineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
}
