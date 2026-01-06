package com.company.procurepulse.service;

import com.company.procurepulse.config.HibernateUtil;
import com.company.procurepulse.dao.AuditLogDao;
import com.company.procurepulse.dao.InvoiceDao;
import com.company.procurepulse.dao.PaymentDao;
import com.company.procurepulse.entity.AuditLog;
import com.company.procurepulse.entity.Invoice;
import com.company.procurepulse.entity.Payment;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class PaymentService {

    private final PaymentDao paymentDao = new PaymentDao();
    private final InvoiceDao invoiceDao = new InvoiceDao();
    private final AuditLogDao auditLogDao = new AuditLogDao();

    /* =================================================
       UC8: Record Payment
       ================================================= */
    public void recordPayment(
            String invoiceNo,
            BigDecimal paidAmount,
            String mode,
            String referenceNo,
            String actor) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Invoice invoice = invoiceDao.findByInvoiceNo(session, invoiceNo);

            if (invoice == null) {
                throw new RuntimeException("Invoice not found");
            }

            if (!invoice.getStatus().equals("APPROVED")
                    && !invoice.getStatus().equals("OVERDUE")
                    && !invoice.getStatus().equals("PARTIALLY_PAID")) {
                throw new RuntimeException("Invoice not eligible for payment");
            }

            Payment payment = new Payment(
                    invoice,
                    paidAmount,
                    mode,
                    referenceNo
            );

            paymentDao.save(session, payment);

            BigDecimal totalPaid =
                    paymentDao.totalPaidForInvoice(session, invoice.getId());

            BigDecimal invoiceTotal =
                    invoice.getAmount().add(invoice.getTaxAmount());

            if (totalPaid.compareTo(invoiceTotal) >= 0) {
                invoice.setStatus("PAID");
            } else {
                invoice.setStatus("PARTIALLY_PAID");
            }

            invoiceDao.update(session, invoice);

            auditLogDao.save(session,
                    new AuditLog(
                            "Payment",
                            payment.getId(),
                            "PAYMENT_RECORDED",
                            actor,
                            "Payment recorded for invoice " + invoiceNo
                    )
            );

            tx.commit();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
