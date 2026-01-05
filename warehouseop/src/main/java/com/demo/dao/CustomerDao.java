package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.Customer;
import com.demo.util.HibernateUtil;

public class CustomerDao {

    public void save(Customer c) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(c);
        tx.commit();
        s.close();
    }

    public Customer getById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Customer c = s.get(Customer.class, id);
        s.close();
        return c;
    }
}
