package com.main;

// 2400030409
// CH.Dhyana Sathwik

import com.dao.mineopsdao;
import com.entity.safetyincident;

import java.sql.Date;

public class SafetyIncidentMain {

    public static void main(String[] args) {

        safetyincident incident = new safetyincident();

        incident.setIncidentId(1);
        incident.setMineId(101);
        incident.setEquipmentId(205);
        incident.setWorkerId(302);
        incident.setIncidentDate(Date.valueOf("2026-01-05"));
        incident.setType("Equipment Failure");
        incident.setSeverity(4);
        incident.setCost(150000.00);
        incident.setStatus("OPEN");

        mineopsdao dao = new mineopsdao();
        dao.save(incident);

        System.out.println("Safety Incident inserted successfully!");
    }
}
