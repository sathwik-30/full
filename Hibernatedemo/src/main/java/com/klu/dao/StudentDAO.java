package com.klu.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.klu.entity.Student;
import com.klu.util.HibernateUtil;

public class StudentDAO {

    public void saveStudent(Student s) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
        }
    }

    public Student getStudent(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    public void updateStudent(Student s) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(s);
            tx.commit();
        }
    }

    public void deleteStudent(Student s) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(s);
            tx.commit();
        }
    }
}
