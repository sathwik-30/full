package com.demo.dao;

import java.time.LocalDate;
import java.util.Scanner;

import com.demo.entity.*;
import com.demo.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MineSiteDao mineDao = new MineSiteDao();
        EquipmentDao equipmentDao = new EquipmentDao();
        WorkerDao workerDao = new WorkerDao();
        ShiftLogDao shiftDao = new ShiftLogDao();
        ProductionLogDao productionDao = new ProductionLogDao();
        EquipmentUsageDao usageDao = new EquipmentUsageDao();
        SafetyIncidentDao incidentDao = new SafetyIncidentDao();

        while (true) {

            System.out.println("\n====== MINE OPS LITE MENU ======");
            System.out.println("1. Register Mine Site");
            System.out.println("2. Update Mine Status");
            System.out.println("3. Register Equipment");
            System.out.println("4. Register Worker");
            System.out.println("5. Create Shift Log");
            System.out.println("6. Record Production");
            System.out.println("7. Record Equipment Usage");
            System.out.println("8. Report Safety Incident");
            System.out.println("9. Close Safety Incident");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    MineSite mine = new MineSite();
                    System.out.print("Mine ID: ");
                    mine.setMineId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Name: ");
                    mine.setName(sc.nextLine());

                    System.out.print("Location: ");
                    mine.setLocation(sc.nextLine());

                    System.out.print("Status (ACTIVE/INACTIVE): ");
                    mine.setStatus(sc.nextLine());

                    mineDao.saveMine(mine);
                    break;
                }

                case 2: {
                    System.out.print("Mine ID: ");
                    int mineId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Status (ACTIVE/INACTIVE): ");
                    String status = sc.nextLine();

                    mineDao.updateMineStatus(mineId, status);
                    break;
                }

                case 3: {
                    Equipment e = new Equipment();
                    System.out.print("Equipment ID: ");
                    e.setEquipmentId(sc.nextInt());

                    System.out.print("Mine ID: ");
                    e.setMineId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Name: ");
                    e.setName(sc.nextLine());

                    System.out.print("Type: ");
                    e.setType(sc.nextLine());

                    System.out.print("Status (WORKING/MAINTENANCE/BROKEN): ");
                    e.setStatus(sc.nextLine());

                    System.out.print("Purchase Date (yyyy-mm-dd): ");
                    e.setPurchaseDate(LocalDate.parse(sc.next()));

                    equipmentDao.saveEquipment(e);
                    break;
                }

                case 4: {
                    Worker w = new Worker();
                    System.out.print("Worker ID: ");
                    w.setWorkerId(sc.nextInt());

                    System.out.print("Mine ID: ");
                    w.setMineId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Name: ");
                    w.setName(sc.nextLine());

                    System.out.print("Role: ");
                    w.setRole(sc.nextLine());

                    System.out.print("Phone: ");
                    w.setPhone(sc.nextLine());

                    workerDao.saveWorker(w);
                    break;
                }

                case 5: {
                    ShiftLog s = new ShiftLog();
                    System.out.print("Shift ID: ");
                    s.setShiftId(sc.nextInt());

                    System.out.print("Mine ID: ");
                    s.setMineId(sc.nextInt());

                    System.out.print("Shift Date (yyyy-mm-dd): ");
                    s.setShiftDate(LocalDate.parse(sc.next()));

                    System.out.print("Shift Type (DAY/NIGHT): ");
                    s.setShiftType(sc.next());

                    System.out.print("Supervisor ID: ");
                    s.setSupervisorId(sc.nextInt());

                    shiftDao.saveShift(s);
                    break;
                }

                case 6: {
                    ProductionLog p = new ProductionLog();
                    System.out.print("Production ID: ");
                    p.setProdId(sc.nextInt());

                    System.out.print("Mine ID: ");
                    p.setMineId(sc.nextInt());

                    System.out.print("Shift ID (or -1 if none): ");
                    int sid = sc.nextInt();
                    p.setShiftId(sid == -1 ? null : sid);

                    System.out.print("Log Date (yyyy-mm-dd): ");
                    p.setLogDate(LocalDate.parse(sc.next()));

                    System.out.print("Tonnes: ");
                    p.setTonnes(sc.nextDouble());

                    System.out.print("Grade: ");
                    p.setGrade(sc.nextDouble());

                    productionDao.saveProduction(p);
                    break;
                }

                case 7: {
                    EquipmentUsage u = new EquipmentUsage();
                    System.out.print("Usage ID: ");
                    u.setUsageId(sc.nextInt());

                    System.out.print("Mine ID: ");
                    u.setMineId(sc.nextInt());

                    System.out.print("Equipment ID: ");
                    u.setEquipmentId(sc.nextInt());

                    System.out.print("Usage Date (yyyy-mm-dd): ");
                    u.setUsageDate(LocalDate.parse(sc.next()));

                    System.out.print("Running Hours: ");
                    u.setRunningHours(sc.nextDouble());

                    System.out.print("Breakdown (Y/N): ");
                    u.setBreakdown(sc.next());

                    System.out.print("Downtime Hours: ");
                    u.setDowntimeHours(sc.nextDouble());

                    usageDao.saveUsage(u);
                    break;
                }

                case 8: {
                    SafetyIncident s = new SafetyIncident();
                    System.out.print("Incident ID: ");
                    s.setIncidentId(sc.nextInt());

                    System.out.print("Mine ID: ");
                    s.setMineId(sc.nextInt());

                    System.out.print("Equipment ID (-1 if none): ");
                    int eid = sc.nextInt();
                    s.setEquipmentId(eid == -1 ? null : eid);

                    System.out.print("Worker ID (-1 if none): ");
                    int wid = sc.nextInt();
                    s.setWorkerId(wid == -1 ? null : wid);

                    System.out.print("Incident Date (yyyy-mm-dd): ");
                    s.setIncidentDate(LocalDate.parse(sc.next()));

                    System.out.print("Type: ");
                    s.setType(sc.next());

                    System.out.print("Severity (1-5): ");
                    s.setSeverity(sc.nextInt());

                    System.out.print("Cost: ");
                    s.setCost(sc.nextDouble());

                    s.setStatus("OPEN");

                    incidentDao.saveIncident(s);
                    break;
                }

                case 9: {
                    System.out.print("Incident ID: ");
                    int id = sc.nextInt();
                    incidentDao.closeIncident(id);
                    break;
                }

                case 0:
                    HibernateUtil.shutdown();
                    sc.close();
                    System.out.println("Application closed.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
