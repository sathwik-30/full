package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.OrderItem;
import com.demo.util.HibernateUtil;

public class OrderItemDao {

    public void save(OrderItem i) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(i);
        tx.commit();
        s.close();
    }
}
