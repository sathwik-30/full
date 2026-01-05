package com.doctor.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.doctor.entity.Patient;
import com.doctor.util.HibernateUtil;

public class PatientDAO {

    // INSERT
    public void savePatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(patient);
        tx.commit();
        session.close();
    }

    // READ
    public List<Patient> getAllPatients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Patient> list = session.createQuery("from Patient", Patient.class).list();
        session.close();
        return list;
    }

    // UPDATE
    public void updatePatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(patient);
        tx.commit();
        session.close();
    }

    // DELETE
    public void deletePatient(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Patient p = session.get(Patient.class, id);
        if (p != null) {
            session.remove(p);
        }
        tx.commit();
        session.close();
    }
}