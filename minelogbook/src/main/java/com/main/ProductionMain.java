package com.main;

// 2400030409
// CH.Dhyana Sathwik

import com.dao.mineopsdao;
import com.entity.productionlog;

import java.sql.Date;

public class ProductionMain {

    public static void main(String[] args) {

        productionlog log = new productionlog();

        log.setProdId(1);
        log.setMineId(101);
        log.setShiftId(2);
        log.setLogDate(Date.valueOf("2026-01-05"));
        log.setTonnes(250.50);
        log.setGrade(4.2);

        mineopsdao dao = new mineopsdao();
        dao.save(log);

        System.out.println("Production Log inserted successfully!");
    }
}
