package com.demo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.Worker;
import com.demo.util.HibernateUtil;

public class WorkerDao {

    public void saveWorker(Worker w) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(w);
        tx.commit();
        s.close();
        System.out.println("Worker registered");
    }

    public Worker findWorkerById(int workerId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Worker w = s.get(Worker.class, workerId);
        s.close();
        return w;
    }
}
