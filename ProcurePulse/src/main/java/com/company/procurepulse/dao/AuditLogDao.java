package com.company.procurepulse.dao;

import com.company.procurepulse.entity.AuditLog;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;

public class AuditLogDao {

    /* =======================
       CREATE
       ======================= */

    public void save(Session session, AuditLog log) {
        session.persist(log);
    }

    /* =======================
       READ
       ======================= */

    public AuditLog findById(Session session, Long id) {
        return session.get(AuditLog.class, id);
    }

    public List<AuditLog> findAll(Session session) {
        String hql = "from AuditLog a order by a.atTime desc";
        return session.createQuery(hql, AuditLog.class).list();
    }

    public List<AuditLog> findByDateRange(
            Session session,
            LocalDateTime from,
            LocalDateTime to) {

        String hql = """
                from AuditLog a
                where a.atTime between :from and :to
                order by a.atTime desc
                """;

        return session.createQuery(hql, AuditLog.class)
                .setParameter("from", from)
                .setParameter("to", to)
                .list();
    }

    /* =======================
       BULK DELETE (Retention)
       ======================= */

    public int deleteOlderThan(Session session, LocalDateTime cutoff) {
        String hql = "delete from AuditLog a where a.atTime < :cutoff";
        return session.createQuery(hql)
                .setParameter("cutoff", cutoff)
                .executeUpdate();
    }
}
