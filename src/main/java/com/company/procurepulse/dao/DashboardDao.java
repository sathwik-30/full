package com.company.procurepulse.dao;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DashboardDao {

    public BigDecimal totalSpendMTD(Session session, int year, int month) {
        String hql = """
                select coalesce(sum(i.amount), 0)
                from Invoice i
                where year(i.invoiceDate) = :yy
                  and month(i.invoiceDate) = :mm
                  and i.status in ('APPROVED','PARTIALLY_PAID','PAID')
                """;

        return session.createQuery(hql, BigDecimal.class)
                .setParameter("yy", year)
                .setParameter("mm", month)
                .uniqueResult();
    }

    public BigDecimal totalSpendYTD(Session session, int year) {
        String hql = """
                select coalesce(sum(i.amount), 0)
                from Invoice i
                where year(i.invoiceDate) = :yy
                  and i.status in ('APPROVED','PARTIALLY_PAID','PAID')
                """;

        return session.createQuery(hql, BigDecimal.class)
                .setParameter("yy", year)
                .uniqueResult();
    }

    public List<Object[]> spendByDepartment(Session session, int year) {
        String hql = """
                select i.department.deptCode, sum(i.amount)
                from Invoice i
                where year(i.invoiceDate) = :yy
                  and i.status in ('APPROVED','PARTIALLY_PAID','PAID')
                group by i.department.deptCode
                order by sum(i.amount) desc
                """;

        return session.createQuery(hql, Object[].class)
                .setParameter("yy", year)
                .list();
    }

    public List<Object[]> spendByVendor(Session session, int year) {
        String hql = """
                select i.vendor.vendorCode, sum(i.amount)
                from Invoice i
                where year(i.invoiceDate) = :yy
                  and i.status in ('APPROVED','PARTIALLY_PAID','PAID')
                group by i.vendor.vendorCode
                order by sum(i.amount) desc
                """;

        return session.createQuery(hql, Object[].class)
                .setParameter("yy", year)
                .list();
    }

    public List<Object[]> invoiceStatusDistribution(Session session) {
        String hql = """
                select i.status, count(i)
                from Invoice i
                group by i.status
                """;

        return session.createQuery(hql, Object[].class).list();
    }

    /* =================================================
       R7: Overdue Amount
       ================================================= */
    public BigDecimal overdueAmount(Session session, LocalDate today) {
        String hql = """
                select coalesce(sum(i.amount), 0)
                from Invoice i
                where i.dueDate < :today
                  and i.status not in ('PAID','CANCELLED')
                """;

        return session.createQuery(hql, BigDecimal.class)
                .setParameter("today", today)
                .uniqueResult();
    }

    public Long overdueCount(Session session, LocalDate today) {
        String hql = """
                select count(i)
                from Invoice i
                where i.dueDate < :today
                  and i.status not in ('PAID','CANCELLED')
                """;

        return session.createQuery(hql, Long.class)
                .setParameter("today", today)
                .uniqueResult();
    }

    public List<Object[]> agingBuckets(
            Session session,
            LocalDate today,
            LocalDate d7,
            LocalDate d30) {

        String hql = """
                select
                  case
                    when i.dueDate >= :today then 'NOT_DUE'
                    when i.dueDate >= :d7 then '1_7_DAYS'
                    when i.dueDate >= :d30 then '8_30_DAYS'
                    else '30_PLUS'
                  end,
                  count(i),
                  sum(i.amount)
                from Invoice i
                where i.status not in ('PAID','CANCELLED')
                group by
                  case
                    when i.dueDate >= :today then 'NOT_DUE'
                    when i.dueDate >= :d7 then '1_7_DAYS'
                    when i.dueDate >= :d30 then '8_30_DAYS'
                    else '30_PLUS'
                  end
                """;

        return session.createQuery(hql, Object[].class)
                .setParameter("today", today)
                .setParameter("d7", d7)
                .setParameter("d30", d30)
                .list();
    }

    public Object[] approvedButUnpaid(Session session) {
        String hql = """
                select count(i), coalesce(sum(i.amount),0)
                from Invoice i
                where i.status = 'APPROVED'
                  and i.id not in (
                      select p.invoice.id from Payment p
                  )
                """;

        return session.createQuery(hql, Object[].class)
                .uniqueResult();
    }
}
