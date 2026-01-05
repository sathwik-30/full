package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.ShiftLog;
import com.demo.util.HibernateUtil;

public class ShiftLogDao {

    public void saveShift(ShiftLog shift) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(shift);
        tx.commit();
        s.close();
        System.out.println("Shift log created");
    }

    public ShiftLog findShiftById(int shiftId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        ShiftLog sh = s.get(ShiftLog.class, shiftId);
        s.close();
        return sh;
    }
}
