package com.company.procurepulse.service;

import com.company.procurepulse.config.HibernateUtil;
import com.company.procurepulse.dao.AuditLogDao;
import com.company.procurepulse.dao.InvoiceDao;
import com.company.procurepulse.entity.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceService {

    private final InvoiceDao invoiceDao = new InvoiceDao();
    private final AuditLogDao auditLogDao = new AuditLogDao();

    public void createDraftInvoice(Invoice invoice, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            if (!"ACTIVE".equals(invoice.getVendor().getStatus())) {
                throw new RuntimeException("Vendor is not ACTIVE");
            }

            recalculateTotals(invoice);
            invoice.setStatus("DRAFT");

            invoiceDao.save(session, invoice);

            auditLogDao.save(session,
                    new AuditLog(
                            "Invoice",
                            invoice.getId(),
                            "INVOICE_DRAFT_CREATED",
                            actor,
                            "Draft invoice created"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /* =================================================
       UC5: Update Invoice Draft
       ================================================= */
    public void updateDraftInvoice(String invoiceNo, Invoice updatedInvoice, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Invoice existing =
                    invoiceDao.findByInvoiceNoWithLines(session, invoiceNo);

            if (existing == null) {
                throw new RuntimeException("Invoice not found");
            }

            if (!"DRAFT".equals(existing.getStatus())) {
                throw new RuntimeException("Only DRAFT invoices can be edited");
            }

            existing.getLines().clear();
            updatedInvoice.getLines().forEach(existing::addLine);

            existing.setInvoiceDate(updatedInvoice.getInvoiceDate());
            existing.setDueDate(updatedInvoice.getDueDate());

            recalculateTotals(existing);

            invoiceDao.update(session, existing);

            auditLogDao.save(session,
                    new AuditLog(
                            "Invoice",
                            existing.getId(),
                            "INVOICE_DRAFT_UPDATED",
                            actor,
                            "Draft invoice updated"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /* =================================================
       UC6: Submit Invoice
       ================================================= */
    public void submitInvoice(String invoiceNo, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Invoice invoice = invoiceDao.findByInvoiceNo(session, invoiceNo);

            if (invoice == null) {
                throw new RuntimeException("Invoice not found");
            }

            if (!"DRAFT".equals(invoice.getStatus())) {
                throw new RuntimeException("Only DRAFT invoices can be submitted");
            }

            if (!"ACTIVE".equals(invoice.getVendor().getStatus())) {
                throw new RuntimeException("Vendor is not ACTIVE");
            }

            invoice.setStatus("SUBMITTED");
            invoice.setSubmittedOn(LocalDateTime.now());

            invoiceDao.update(session, invoice);

            auditLogDao.save(session,
                    new AuditLog(
                            "Invoice",
                            invoice.getId(),
                            "INVOICE_SUBMITTED",
                            actor,
                            "Invoice submitted"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /* =================================================
       UC7: Approve Invoice
       ================================================= */
    public void approveInvoice(String invoiceNo, Employee approver, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Invoice invoice = invoiceDao.findByInvoiceNo(session, invoiceNo);

            if (invoice == null) {
                throw new RuntimeException("Invoice not found");
            }

            if (!"SUBMITTED".equals(invoice.getStatus())) {
                throw new RuntimeException("Only SUBMITTED invoices can be approved");
            }

            invoice.setStatus("APPROVED");
            invoice.setApprovedBy(approver);
            invoice.setApprovedOn(LocalDateTime.now());

            invoiceDao.update(session, invoice);

            auditLogDao.save(session,
                    new AuditLog(
                            "Invoice",
                            invoice.getId(),
                            "INVOICE_APPROVED",
                            actor,
                            "Invoice approved"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void rejectInvoice(String invoiceNo, String reason, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Invoice invoice = invoiceDao.findByInvoiceNo(session, invoiceNo);

            if (invoice == null) {
                throw new RuntimeException("Invoice not found");
            }

            if (!"SUBMITTED".equals(invoice.getStatus())) {
                throw new RuntimeException("Only SUBMITTED invoices can be rejected");
            }

            invoice.setStatus("REJECTED");
            invoice.setRejectReason(reason);

            invoiceDao.update(session, invoice);

            auditLogDao.save(session,
                    new AuditLog(
                            "Invoice",
                            invoice.getId(),
                            "INVOICE_REJECTED",
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

    public void cancelInvoice(String invoiceNo, String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Invoice invoice = invoiceDao.findByInvoiceNo(session, invoiceNo);

            if (invoice == null) {
                throw new RuntimeException("Invoice not found");
            }

            if ("PAID".equals(invoice.getStatus())) {
                throw new RuntimeException("Paid invoice cannot be cancelled");
            }

            invoice.setStatus("CANCELLED");

            invoiceDao.update(session, invoice);

            auditLogDao.save(session,
                    new AuditLog(
                            "Invoice",
                            invoice.getId(),
                            "INVOICE_CANCELLED",
                            actor,
                            "Invoice cancelled"
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    private void recalculateTotals(Invoice invoice) {

        BigDecimal total = BigDecimal.ZERO;

        for (InvoiceLine line : invoice.getLines()) {
            BigDecimal lineTotal =
                    line.getUnitPrice().multiply(BigDecimal.valueOf(line.getQty()));
            line.setLineTotal(lineTotal);
            total = total.add(lineTotal);
        }

        invoice.setAmount(total);
        invoice.setTaxAmount(total.multiply(BigDecimal.valueOf(0.18)));
    }
}
