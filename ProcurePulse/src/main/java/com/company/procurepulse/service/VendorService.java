package com.company.procurepulse.service;

import com.company.procurepulse.config.HibernateUtil;
import com.company.procurepulse.dao.AuditLogDao;
import com.company.procurepulse.dao.VendorDao;
import com.company.procurepulse.entity.AuditLog;
import com.company.procurepulse.entity.Vendor;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class VendorService {

    private final VendorDao vendorDao = new VendorDao();
    private final AuditLogDao auditLogDao = new AuditLogDao();

    public void createVendor(Vendor vendor, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            // Validation: vendor code must be unique
            if (vendorDao.existsByVendorCode(session, vendor.getVendorCode())) {
                throw new RuntimeException("Vendor code already exists");
            }

            vendorDao.save(session, vendor);

            auditLogDao.save(session,
                    new AuditLog(
                            "Vendor",
                            vendor.getId(),
                            "VENDOR_CREATED",
                            actor,
                            "Vendor onboarded"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void updateVendor(
            String vendorCode,
            String email,
            String phone,
            String gstin,
            String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Vendor vendor = vendorDao.findByVendorCode(session, vendorCode);
            if (vendor == null) {
                throw new RuntimeException("Vendor not found");
            }

            vendor.setEmail(email);
            vendor.setPhone(phone);
            vendor.setGstin(gstin);

            vendorDao.update(session, vendor);

            auditLogDao.save(session,
                    new AuditLog(
                            "Vendor",
                            vendor.getId(),
                            "VENDOR_UPDATED",
                            actor,
                            "Vendor details updated"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /* =================================================
       UC3: Vendor Freeze / Blacklist
       ================================================= */
    public void changeVendorStatus(
            String vendorCode,
            String newStatus,
            String reason,
            String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Vendor vendor = vendorDao.findByVendorCode(session, vendorCode);
            if (vendor == null) {
                throw new RuntimeException("Vendor not found");
            }

            vendor.setStatus(newStatus);

            vendorDao.update(session, vendor);

            auditLogDao.save(session,
                    new AuditLog(
                            "Vendor",
                            vendor.getId(),
                            "VENDOR_STATUS_CHANGED",
                            actor,
                            reason
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
