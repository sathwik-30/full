package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.MineSite;
import com.demo.util.HibernateUtil;

public class MineSiteDao {

    public void saveMine(MineSite mine) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(mine);
        tx.commit();
        s.close();
        System.out.println("Mine registered successfully");
    }

    public MineSite findMineById(int mineId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        MineSite mine = s.get(MineSite.class, mineId);
        s.close();
        return mine;
    }

    public void updateMineStatus(int mineId, String status) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        MineSite mine = s.get(MineSite.class, mineId);
        if (mine != null) {
            mine.setStatus(status);
            System.out.println("Mine status updated");
        } else {
            System.out.println("Mine not found");
        }

        tx.commit();
        s.close();
    }
}
