package com.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.util.HibernateUtil;

public class mineopsdao {

    public void save(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(obj);


        tx.commit();
        session.close();
    }
}