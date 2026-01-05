package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.SalesOrder;
import com.demo.util.HibernateUtil;

public class SalesOrderDao {

    public void save(SalesOrder o) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(o);
        tx.commit();
        s.close();
    }

    public SalesOrder getById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        SalesOrder o = s.get(SalesOrder.class, id);
        s.close();
        return o;
    }
}
