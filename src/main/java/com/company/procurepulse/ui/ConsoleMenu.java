package com.company.procurepulse.ui;

import java.util.Scanner;

import com.company.procurepulse.entity.Vendor;
import com.company.procurepulse.service.VendorService;

public class ConsoleMenu {

    public static void main(String[] args) {

        System.out.println("ProcurePulse Application Started");

        Scanner sc = new Scanner(System.in);
        VendorService vendorService = new VendorService();

        try {
            // ---- Read input from user ----
            System.out.print("Enter Vendor Code: ");
            String vendorCode = sc.nextLine();

            System.out.print("Enter Vendor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter GSTIN: ");
            String gstin = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Status (ACTIVE / ON_HOLD): ");
            String status = sc.nextLine();

            // ---- Create Vendor object ----
            Vendor vendor = new Vendor();
            vendor.setVendorCode(vendorCode);
            vendor.setName(name);
            vendor.setGstin(gstin);
            vendor.setEmail(email);
            vendor.setPhone(phone);
            vendor.setStatus(status);

            // ---- Insert into DB ----
            vendorService.createVendor(vendor);

            System.out.println("✅ Vendor inserted successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error inserting vendor: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
