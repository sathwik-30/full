package com.company.procurepulse.dao;

import com.company.procurepulse.entity.Vendor;
import org.hibernate.Session;

import java.util.List;

public class VendorDao {

    /* =======================
       CREATE
       ======================= */

    public void save(Session session, Vendor vendor) {
        session.persist(vendor);
    }

    /* =======================
       READ
       ======================= */

    public Vendor findById(Session session, Long id) {
        return session.get(Vendor.class, id);
    }

    public Vendor findByVendorCode(Session session, String vendorCode) {
        String hql = "from Vendor v where v.vendorCode = :code";
        return session.createQuery(hql, Vendor.class)
                .setParameter("code", vendorCode)
                .uniqueResult();
    }

    public List<Vendor> findAll(Session session) {
        String hql = "from Vendor v order by v.name";
        return session.createQuery(hql, Vendor.class).list();
    }

    public List<Vendor> findByStatus(Session session, String status) {
        String hql = "from Vendor v where v.status = :status order by v.name";
        return session.createQuery(hql, Vendor.class)
                .setParameter("status", status)
                .list();
    }

    /* =======================
       UPDATE
       ======================= */

    public void update(Session session, Vendor vendor) {
        session.merge(vendor);
    }

    /* =======================
       DELETE (not used – soft delete preferred)
       ======================= */

    public void delete(Session session, Vendor vendor) {
        session.remove(vendor);
    }

    /* =======================
       VALIDATION / CHECKS
       ======================= */

    public boolean existsByVendorCode(Session session, String vendorCode) {
        String hql = "select count(v) from Vendor v where v.vendorCode = :code";
        Long count = session.createQuery(hql, Long.class)
                .setParameter("code", vendorCode)
                .uniqueResult();
        return count != null && count > 0;
    }
}
