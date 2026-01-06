package com.company.procurepulse.service;

import com.company.procurepulse.config.HibernateUtil;
import com.company.procurepulse.dao.DashboardDao;
import com.company.procurepulse.dto.*;

import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardService {

    private final DashboardDao dashboardDao = new DashboardDao();

    /* =================================================
       R1: Total Spend (MTD)
       ================================================= */
    public BigDecimal getTotalSpendMTD(int year, int month) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return dashboardDao.totalSpendMTD(session, year, month);
        }
    }

    /* =================================================
       R2: Total Spend (YTD)
       ================================================= */
    public BigDecimal getTotalSpendYTD(int year) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return dashboardDao.totalSpendYTD(session, year);
        }
    }

    /* =================================================
       R3: Spend by Department (DTO)
       ================================================= */
    public List<DepartmentSpendDTO> getSpendByDepartment(int year) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Object[]> rows =
                    dashboardDao.spendByDepartment(session, year);

            return rows.stream()
                    .map(r -> new DepartmentSpendDTO(
                            (String) r[0],
                            (BigDecimal) r[1]
                    ))
                    .collect(Collectors.toList());
        }
    }

    /* =================================================
       R4: Spend by Vendor (DTO)
       ================================================= */
    public List<VendorSpendDTO> getSpendByVendor(int year) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Object[]> rows =
                    dashboardDao.spendByVendor(session, year);

            return rows.stream()
                    .map(r -> new VendorSpendDTO(
                            (String) r[0],
                            (BigDecimal) r[1]
                    ))
                    .collect(Collectors.toList());
        }
    }

    /* =================================================
       R5: Invoice Status Distribution (DTO)
       ================================================= */
    public List<InvoiceStatusCountDTO> getInvoiceStatusDistribution() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Object[]> rows =
                    dashboardDao.invoiceStatusDistribution(session);

            return rows.stream()
                    .map(r -> new InvoiceStatusCountDTO(
                            (String) r[0],
                            (Long) r[1]
                    ))
                    .collect(Collectors.toList());
        }
    }

    /* =================================================
       R7: Overdue Amount
       ================================================= */
    public BigDecimal getOverdueAmount() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return dashboardDao.overdueAmount(session, LocalDate.now());
        }
    }

    /* =================================================
       R8: Overdue Count
       ================================================= */
    public Long getOverdueCount() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return dashboardDao.overdueCount(session, LocalDate.now());
        }
    }

    /* =================================================
       R9: Aging Buckets (DTO)
       ================================================= */
    public List<AgingBucketDTO> getAgingBuckets() {

        LocalDate today = LocalDate.now();
        LocalDate d7 = today.minusDays(7);
        LocalDate d30 = today.minusDays(30);

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Object[]> rows =
                    dashboardDao.agingBuckets(session, today, d7, d30);

            return rows.stream()
                    .map(r -> new AgingBucketDTO(
                            (String) r[0],
                            (Long) r[1],
                            (BigDecimal) r[2]
                    ))
                    .collect(Collectors.toList());
        }
    }

    /* =================================================
       R10: Approved but Unpaid (DTO)
       ================================================= */
    public ApprovedUnpaidDTO getApprovedButUnpaid() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Object[] row =
                    dashboardDao.approvedButUnpaid(session);

            return new ApprovedUnpaidDTO(
                    (Long) row[0],
                    (BigDecimal) row[1]
            );
        }
    }
}
