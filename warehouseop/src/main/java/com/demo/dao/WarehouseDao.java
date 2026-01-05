package com.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.demo.entity.Warehouse;
import com.demo.util.HibernateUtil;

public class WarehouseDao {

    public void save(Warehouse w) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(w);
        tx.commit();
        s.close();
    }

    public Warehouse getById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Warehouse w = s.get(Warehouse.class, id);
        s.close();
        return w;
    }

    public List<Warehouse> getAll() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Warehouse> list = s.createQuery("from Warehouse").list();
        s.close();
        return list;
    }
}
