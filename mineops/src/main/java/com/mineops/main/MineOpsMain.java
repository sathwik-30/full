package com.mineops.main;

import com.mineops.dao.MineSiteDAO;
import com.mineops.entity.MineSite;
import java.util.Scanner;

public class MineOpsMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MineSiteDAO dao = new MineSiteDAO();

        System.out.println("1. Add Mine\n2. View All Mines");
        int ch = sc.nextInt();

        switch(ch) {
            case 1:
                MineSite m = new MineSite();
                System.out.print("Enter Mine ID: ");
                m.setMineId(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter Name: ");
                m.setName(sc.nextLine());
                System.out.print("Enter Location: ");
                m.setLocation(sc.nextLine());
                System.out.print("Enter Status (ACTIVE/INACTIVE): ");
                m.setStatus(sc.nextLine());

                dao.saveMine(m);
                break;

            case 2:
                dao.getAllMines().forEach(System.out::println);
                break;
        }
    }
}
