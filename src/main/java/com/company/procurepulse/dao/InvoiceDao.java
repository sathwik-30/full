package com.company.procurepulse.dao;

import com.company.procurepulse.entity.Invoice;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class InvoiceDao {

    /* =======================
       CREATE / UPDATE
       ======================= */

    public void save(Session session, Invoice invoice) {
        session.persist(invoice);
    }

    public Invoice update(Session session, Invoice invoice) {
        return session.merge(invoice);
    }

    /* =======================
       READ
       ======================= */

    public Invoice findById(Session session, Long id) {
        return session.get(Invoice.class, id);
    }

    public Invoice findByInvoiceNo(Session session, String invoiceNo) {
        String hql = "from Invoice i where i.invoiceNo = :invNo";
        return session.createQuery(hql, Invoice.class)
                .setParameter("invNo", invoiceNo)
                .uniqueResult();
    }

    /* =======================
       JOIN FETCH (avoid N+1)
       ======================= */

    public Invoice findByInvoiceNoWithLines(Session session, String invoiceNo) {
        String hql = """
                select distinct i
                from Invoice i
                left join fetch i.lines
                where i.invoiceNo = :invNo
                """;
        return session.createQuery(hql, Invoice.class)
                .setParameter("invNo", invoiceNo)
                .uniqueResult();
    }

    /* =======================
       LIST / SEARCH
       ======================= */

    public List<Invoice> findByDepartmentAndDateRange(
            Session session, String deptCode,
            LocalDate from, LocalDate to) {

        String hql = """
                from Invoice i
                where i.department.deptCode = :dept
                  and i.invoiceDate between :from and :to
                order by i.invoiceDate desc
                """;

        return session.createQuery(hql, Invoice.class)
                .setParameter("dept", deptCode)
                .setParameter("from", from)
                .setParameter("to", to)
                .list();
    }

    public List<Invoice> findOverdueInvoices(Session session, LocalDate today) {
        String hql = """
                from Invoice i
                where i.dueDate < :today
                  and i.status not in ('PAID', 'CANCELLED')
                order by i.dueDate asc
                """;

        return session.createQuery(hql, Invoice.class)
                .setParameter("today", today)
                .list();
    }

    /* =======================
       BULK UPDATE
       ======================= */

    public int markOverdue(Session session, LocalDate today) {
        String hql = """
                update Invoice i
                set i.status = 'OVERDUE'
                where i.dueDate < :today
                  and i.status not in ('PAID', 'CANCELLED')
                """;

        return session.createQuery(hql)
                .setParameter("today", today)
                .executeUpdate();
    }
}
