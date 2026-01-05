package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.PurchaseReceipt;
import com.demo.util.HibernateUtil;

public class PurchaseReceiptDao {

    public void save(PurchaseReceipt r) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(r);
        tx.commit();
        s.close();
    }
}
