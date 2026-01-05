package com.main;

// 2400030409
// CH.Dhyana Sathwik

import com.dao.mineopsdao;
import com.entity.shiftlog;

import java.sql.Date;

public class ShiftLogMain {

    public static void main(String[] args) {

        shiftlog shift = new shiftlog();

        shift.setShiftId(1);
        shift.setMineId(101);
        shift.setShiftDate(Date.valueOf("2026-01-06"));
        shift.setShiftType("NIGHT");
        shift.setSupervisorId(501);

        mineopsdao dao = new mineopsdao();
        dao.save(shift);

        System.out.println("Shift Log inserted successfully!");
    }
}
