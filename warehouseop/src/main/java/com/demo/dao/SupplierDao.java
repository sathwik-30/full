package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.Supplier;
import com.demo.util.HibernateUtil;

public class SupplierDao {

    public void save(Supplier s1) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(s1);
        tx.commit();
        s.close();
    }

    public Supplier getById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Supplier sp = s.get(Supplier.class, id);
        s.close();
        return sp;
    }
}
