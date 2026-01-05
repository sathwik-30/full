package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.Bin;
import com.demo.util.HibernateUtil;

public class BinDao {

    public void save(Bin b) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(b);
        tx.commit();
        s.close();
    }
}
