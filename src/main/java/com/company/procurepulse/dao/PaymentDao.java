package com.company.procurepulse.dao;

import com.company.procurepulse.entity.Payment;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class PaymentDao {

    /* =======================
       CREATE
       ======================= */

    public void save(Session session, Payment payment) {
        session.persist(payment);
    }

    /* =======================
       READ
       ======================= */

    public Payment findById(Session session, Long id) {
        return session.get(Payment.class, id);
    }

    public List<Payment> findByInvoiceId(Session session, Long invoiceId) {
        String hql = "from Payment p where p.invoice.id = :invId order by p.paidOn";
        return session.createQuery(hql, Payment.class)
                .setParameter("invId", invoiceId)
                .list();
    }

    /* =======================
       AGGREGATES (HQL)
       ======================= */

    public BigDecimal totalPaidForInvoice(Session session, Long invoiceId) {
        String hql = "select coalesce(sum(p.paidAmount), 0) " +
                     "from Payment p where p.invoice.id = :invId";

        return session.createQuery(hql, BigDecimal.class)
                .setParameter("invId", invoiceId)
                .uniqueResult();
    }

    public List<Object[]> paymentModeMix(Session session, int year, int month) {
        String hql = """
                select p.mode, count(p), sum(p.paidAmount)
                from Payment p
                where year(p.paidOn) = :yy
                  and month(p.paidOn) = :mm
                group by p.mode
                order by sum(p.paidAmount) desc
                """;

        return session.createQuery(hql, Object[].class)
                .setParameter("yy", year)
                .setParameter("mm", month)
                .list();
    }
}
