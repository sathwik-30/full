package com.company.procurepulse.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs",
       indexes = {
           @Index(name = "idx_audit_time", columnList = "at_time")
       })
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_name", nullable = false, length = 60)
    private String entityName;

    @Column(name = "entity_id", nullable = false)
    private Long entityId;

    @Column(name = "action", nullable = false, length = 60)
    private String action;

    @Column(name = "actor", nullable = false, length = 120)
    private String actor;

    @Column(name = "at_time", nullable = false)
    private LocalDateTime atTime;

    @Column(name = "remarks", length = 255)
    private String remarks;

    /* =======================
       Constructors
       ======================= */

    public AuditLog() {
    }

    public AuditLog(String entityName, Long entityId,
                    String action, String actor,
                    String remarks) {
        this.entityName = entityName;
        this.entityId = entityId;
        this.action = action;
        this.actor = actor;
        this.remarks = remarks;
        this.atTime = LocalDateTime.now();
    }

    /* =======================
       Getters & Setters
       ======================= */

    public Long getId() {
        return id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public LocalDateTime getAtTime() {
        return atTime;
    }

    public void setAtTime(LocalDateTime atTime) {
        this.atTime = atTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
