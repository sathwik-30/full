package com.demo.dao;

import java.util.Date;
import java.util.Scanner;

import com.demo.dao.*;
import com.demo.entity.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        WarehouseDao warehouseDao = new WarehouseDao();
        SupplierDao supplierDao = new SupplierDao();
        CustomerDao customerDao = new CustomerDao();
        ProductDao productDao = new ProductDao();
        BinDao binDao = new BinDao();
        PurchaseReceiptDao receiptDao = new PurchaseReceiptDao();
        PurchaseItemDao purchaseItemDao = new PurchaseItemDao();
        SalesOrderDao salesOrderDao = new SalesOrderDao();
        OrderItemDao orderItemDao = new OrderItemDao();
        DispatchDao dispatchDao = new DispatchDao();
        ReturnLogDao returnLogDao = new ReturnLogDao();

        while (true) {

            System.out.println("\n===== WAREOPS LITE MENU =====");
            System.out.println("1. Add Warehouse");
            System.out.println("2. Add Supplier");
            System.out.println("3. Add Customer");
            System.out.println("4. Add Product");
            System.out.println("5. Create Purchase Receipt");
            System.out.println("6. Create Sales Order");
            System.out.println("7. Dispatch Order");
            System.out.println("8. Process Return");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1: // Warehouse
                Warehouse w = new Warehouse();
                System.out.print("Warehouse ID: ");
                w.setWarehouseId(sc.nextInt());
                sc.nextLine();
                System.out.print("Name: ");
                w.setName(sc.nextLine());
                System.out.print("City: ");
                w.setCity(sc.nextLine());
                System.out.print("Status: ");
                w.setStatus(sc.nextLine());
                warehouseDao.save(w);
                System.out.println("✅ Warehouse saved");
                break;

            case 2: // Supplier
                Supplier s = new Supplier();
                System.out.print("Supplier ID: ");
                s.setSupplierId(sc.nextInt());
                sc.nextLine();
                System.out.print("Name: ");
                s.setName(sc.nextLine());
                System.out.print("GST Number: ");
                s.setGstNumber(sc.nextLine());
                System.out.print("Phone: ");
                s.setPhone(sc.nextLine());
                System.out.print("City: ");
                s.setCity(sc.nextLine());
                System.out.print("Status: ");
                s.setStatus(sc.nextLine());
                supplierDao.save(s);
                System.out.println("✅ Supplier saved");
                break;

            case 3: // Customer
                Customer c = new Customer();
                System.out.print("Customer ID: ");
                c.setCustomerId(sc.nextInt());
                sc.nextLine();
                System.out.print("Name: ");
                c.setName(sc.nextLine());
                System.out.print("Phone: ");
                c.setPhone(sc.nextLine());
                System.out.print("City: ");
                c.setCity(sc.nextLine());
                System.out.print("Customer Type: ");
                c.setCustomerType(sc.nextLine());
                customerDao.save(c);
                System.out.println("✅ Customer saved");
                break;

            case 4: // Product
                Product p = new Product();
                System.out.print("Product ID: ");
                p.setProductId(sc.nextInt());
                sc.nextLine();
                System.out.print("SKU: ");
                p.setSku(sc.nextLine());
                System.out.print("Name: ");
                p.setName(sc.nextLine());
                System.out.print("Category: ");
                p.setCategory(sc.nextLine());
                System.out.print("Unit Price: ");
                p.setUnitPrice(sc.nextDouble());
                System.out.print("Reorder Level: ");
                p.setReorderLevel(sc.nextInt());
                sc.nextLine();
                System.out.print("Status: ");
                p.setStatus(sc.nextLine());
                productDao.save(p);
                System.out.println("✅ Product saved");
                break;

            case 5: // Purchase Receipt
                PurchaseReceipt pr = new PurchaseReceipt();
                System.out.print("Receipt ID: ");
                pr.setReceiptId(sc.nextInt());
                System.out.print("Warehouse ID: ");
                pr.setWarehouseId(sc.nextInt());
                System.out.print("Supplier ID: ");
                pr.setSupplierId(sc.nextInt());
                pr.setReceiptDate(new Date());
                sc.nextLine();
                System.out.print("Invoice No: ");
                pr.setInvoiceNo(sc.nextLine());
                System.out.print("Total Amount: ");
                pr.setTotalAmount(sc.nextDouble());
                receiptDao.save(pr);
                System.out.println("✅ Purchase Receipt saved");
                break;

            case 6: // Sales Order
                SalesOrder so = new SalesOrder();
                System.out.print("Order ID: ");
                so.setOrderId(sc.nextInt());
                System.out.print("Warehouse ID: ");
                so.setWarehouseId(sc.nextInt());
                System.out.print("Customer ID: ");
                so.setCustomerId(sc.nextInt());
                so.setOrderDate(new Date());
                so.setPromisedDate(new Date());
                sc.nextLine();
                so.setStatus("NEW");
                salesOrderDao.save(so);
                System.out.println("✅ Sales Order created");
                break;

            case 7: // Dispatch
                Dispatch d = new Dispatch();
                System.out.print("Dispatch ID: ");
                d.setDispatchId(sc.nextInt());
                System.out.print("Warehouse ID: ");
                d.setWarehouseId(sc.nextInt());
                System.out.print("Order ID: ");
                d.setOrderId(sc.nextInt());
                d.setDispatchDate(new Date());
                sc.nextLine();
                System.out.print("Courier: ");
                d.setCourier(sc.nextLine());
                System.out.print("Tracking No: ");
                d.setTrackingNo(sc.nextLine());
                d.setStatus("IN_TRANSIT");
                dispatchDao.save(d);
                System.out.println("✅ Order dispatched");
                break;

            case 8: // Return
                ReturnLog r = new ReturnLog();
                System.out.print("Return ID: ");
                r.setReturnId(sc.nextInt());
                System.out.print("Warehouse ID: ");
                r.setWarehouseId(sc.nextInt());
                System.out.print("Order ID: ");
                r.setOrderId(sc.nextInt());
                System.out.print("Product ID: ");
                r.setProductId(sc.nextInt());
                r.setReturnDate(new Date());
                System.out.print("Quantity: ");
                r.setQty(sc.nextInt());
                sc.nextLine();
                System.out.print("Reason: ");
                r.setReason(sc.nextLine());
                System.out.print("Refund Amount: ");
                r.setRefundAmount(sc.nextDouble());
                r.setStatus("OPEN");
                returnLogDao.save(r);
                System.out.println("✅ Return logged");
                break;

            case 0:
                System.out.println("Exiting application...");
                sc.close();
                System.exit(0);

            default:
                System.out.println(" Invalid choice");
            }
        }
    }
}
