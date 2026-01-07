package com.company.procurepulse.ui;


import com.company.procurepulse.entity.*;
import com.company.procurepulse.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class MainApp {

    private static final VendorService vendorService = new VendorService();
    private static final InvoiceService invoiceService = new InvoiceService();
    private static final PaymentService paymentService = new PaymentService();
    private static final DashboardService dashboardService = new DashboardService();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      ProcurePulse System        ");
        System.out.println("=================================");

        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> createVendor();
                    case 2 -> createInvoiceDraft();
                    case 3 -> submitInvoice();
                    case 4 -> approveInvoice();
                    case 5 -> recordPayment();
                    case 6 -> showDashboard();
                    case 0 -> {
                        System.out.println("Exiting system...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.err.println("❌ ERROR: " + e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Create Vendor");
        System.out.println("2. Create Invoice Draft");
        System.out.println("3. Submit Invoice");
        System.out.println("4. Approve Invoice");
        System.out.println("5. Record Payment");
        System.out.println("6. View Dashboard");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    /* =======================
       MENU OPERATIONS
       ======================= */

    private static void createVendor() {

        System.out.print("Vendor Code: ");
        String code = sc.nextLine();

        System.out.print("Vendor Name: ");
        String name = sc.nextLine();

        Vendor vendor = new Vendor(
                code,
                name,
                null,
                null,
                null,
                "ACTIVE"
        );

        vendorService.createVendor(vendor, "admin@company.com");
        System.out.println(" Vendor created");
    }

    private static void createInvoiceDraft() {

        // NOTE: In real app, these come from DB.
        // For demo, we assume objects already exist.
        Vendor vendor = new Vendor("VEN-001", "Demo Vendor", null, null, null, "ACTIVE");
        Department dept = new Department("CSE", "Computer Science", BigDecimal.valueOf(2500000));
        Employee emp = new Employee("EMP-01", "Ravi", "ravi@company.com", dept);

        System.out.print("Invoice No: ");
        String invNo = sc.nextLine();

        Invoice invoice = new Invoice(
                invNo,
                vendor,
                dept,
                emp,
                LocalDate.now(),
                LocalDate.now().plusDays(30)
        );

        invoice.addLine(new InvoiceLine("Router", 2, BigDecimal.valueOf(25000)));
        invoice.addLine(new InvoiceLine("Switch", 1, BigDecimal.valueOf(15000)));

        invoiceService.createDraftInvoice(invoice, emp.getEmail());
        System.out.println("Invoice draft created");
    }

    private static void submitInvoice() {
        System.out.print("Invoice No: ");
        String invNo = sc.nextLine();

        invoiceService.submitInvoice(invNo, "user@company.com");
        System.out.println("Invoice submitted");
    }

    private static void approveInvoice() {
        System.out.print("Invoice No: ");
        String invNo = sc.nextLine();

        Department dept = new Department("FIN", "Finance", BigDecimal.valueOf(5000000));
        Employee approver = new Employee("EMP-99", "Finance Head", "fin@company.com", dept);

        invoiceService.approveInvoice(invNo, approver, approver.getEmail());
        System.out.println(" Invoice approved");
    }

    private static void recordPayment() {

        System.out.print("Invoice No: ");
        String invNo = sc.nextLine();

        System.out.print("Paid Amount: ");
        BigDecimal amt = sc.nextBigDecimal();
        sc.nextLine();

        paymentService.recordPayment(
                invNo,
                amt,
                "UPI",
                "REF12345",
                "accounts@company.com"
        );

        System.out.println(" Payment recorded");
    }

    private static void showDashboard() {

        System.out.println("\n--- DASHBOARD ---");

        BigDecimal mtd = dashboardService.getTotalSpendMTD(
                LocalDate.now().getYear(),
                LocalDate.now().getMonthValue()
        );

        BigDecimal overdue = dashboardService.getOverdueAmount();
        Long overdueCount = dashboardService.getOverdueCount();

        System.out.println("Total Spend (MTD): " + mtd);
        System.out.println("Overdue Amount   : " + overdue);
        System.out.println("Overdue Count    : " + overdueCount);
    }
}
