package com.main;

import java.sql.Date;
import java.time.LocalDate;

import com.dao.mineopsdao;

import com.entity.equipment;

public class EquipmentMain {

    public static void main(String[] args) {

        equipment e = new equipment();
        e.setEquipmentId(1);
        e.setMineId(1);
        e.setName("ABC");

        e.setPurchaseDate(Date.valueOf(LocalDate.now()));

        e.setStatus("ACTIVE");
        e.setType("Mining Machine");

        mineopsdao dao = new mineopsdao();
        dao.save(e);

        System.out.println("Equipment inserted successfully!");
    }
}
