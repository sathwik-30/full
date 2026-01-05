package com.mineops.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.mineops.entity.MineSite;
import com.mineops.util.HibernateUtil;
import java.util.List;

public class MineSiteDAO {

    // 1. INSERT MineSite
    public void saveMine(MineSite mine) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(mine);
            tx.commit();
            System.out.println("Mine Added Successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // 2. UPDATE Mine Status
    public void updateStatus(int mineId, String newStatus) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            MineSite mine = session.get(MineSite.class, mineId);

            if (mine != null) {
                mine.setStatus(newStatus);
                session.update(mine);
                tx.commit();
                System.out.println("Status Updated Successfully!");
            } else {
                System.out.println("Mine Not Found!");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // 3. DELETE MineSite
    public void deleteMine(int mineId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            MineSite mine = session.get(MineSite.class, mineId);
            if (mine != null) {
                session.delete(mine);
                tx.commit();
                System.out.println("Mine Deleted Successfully!");
            } else {
                System.out.println("Mine Not Found!");
            }

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // 4. GET Mine by Id
    public MineSite getMineById(int mineId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(MineSite.class, mineId);
        }
    }

    // 5. LIST All Mines
    public List<MineSite> getAllMines() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from MineSite", MineSite.class).list();
        }
    }
}
