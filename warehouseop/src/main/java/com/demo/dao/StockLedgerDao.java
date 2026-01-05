package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.StockLedger;
import com.demo.util.HibernateUtil;

public class StockLedgerDao {

    public void save(StockLedger l) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(l);
        tx.commit();
        s.close();
    }
}
