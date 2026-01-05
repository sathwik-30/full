package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.Equipment;
import com.demo.util.HibernateUtil;

public class EquipmentDao {

    public void saveEquipment(Equipment e) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(e);
        tx.commit();
        s.close();
        System.out.println("Equipment registered");
    }

    public Equipment findById(int equipmentId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Equipment e = s.get(Equipment.class, equipmentId);
        s.close();
        return e;
    }

    public void transferEquipment(int equipmentId, int newMineId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        Equipment e = s.get(Equipment.class, equipmentId);
        if (e != null) {
            e.setMineId(newMineId);
            System.out.println("Equipment transferred");
        } else {
            System.out.println("Equipment not found");
        }

        tx.commit();
        s.close();
    }
}
