package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.Dispatch;
import com.demo.util.HibernateUtil;

public class DispatchDao {

    public void save(Dispatch d) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(d);
        tx.commit();
        s.close();
    }
}
