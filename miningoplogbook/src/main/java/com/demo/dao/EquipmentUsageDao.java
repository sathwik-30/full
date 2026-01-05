package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.EquipmentUsage;
import com.demo.util.HibernateUtil;

public class EquipmentUsageDao {

    public void saveUsage(EquipmentUsage u) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(u);
        tx.commit();
        s.close();
        System.out.println("Equipment usage recorded");
    }
}
