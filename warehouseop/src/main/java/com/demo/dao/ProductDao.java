package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.Product;
import com.demo.util.HibernateUtil;

public class ProductDao {

    public void save(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }

    public Product getById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Product p = s.get(Product.class, id);
        s.close();
        return p;
    }

    public void deactivate(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Product p = s.get(Product.class, id);
        if (p != null) {
            p.setStatus("INACTIVE");
        }
        tx.commit();
        s.close();
    }
}
