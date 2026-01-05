package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.SafetyIncident;
import com.demo.util.HibernateUtil;

public class SafetyIncidentDao {

    public void saveIncident(SafetyIncident sIncident) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(sIncident);
        tx.commit();
        s.close();
        System.out.println("Safety incident reported");
    }

    public void closeIncident(int incidentId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        SafetyIncident si = s.get(SafetyIncident.class, incidentId);
        if (si != null && "OPEN".equals(si.getStatus())) {
            si.setStatus("CLOSED");
            System.out.println("Incident closed");
        } else {
            System.out.println("Incident not found or already closed");
        }

        tx.commit();
        s.close();
    }
}
