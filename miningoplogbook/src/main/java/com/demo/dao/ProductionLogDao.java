package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.ProductionLog;
import com.demo.util.HibernateUtil;

public class ProductionLogDao {

    public void saveProduction(ProductionLog p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
        System.out.println("Production log saved");
    }
}
