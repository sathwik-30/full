package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.PurchaseItem;
import com.demo.util.HibernateUtil;

public class PurchaseItemDao {

    public void save(PurchaseItem p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }
}
