package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.ReturnLog;
import com.demo.util.HibernateUtil;

public class ReturnLogDao {

    public void save(ReturnLog r) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(r);
        tx.commit();
        s.close();
    }
}
