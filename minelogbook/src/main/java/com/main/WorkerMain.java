package com.main;

// 2400030409
// CH.Dhyana Sathwik

import com.dao.mineopsdao;
import com.entity.worker;

public class WorkerMain {

    public static void main(String[] args) {

        worker w = new worker();

        w.setWorkerId(1);
        w.setMineId(101);
        w.setName("Ramesh Kumar");
        w.setRole("Supervisor");
        w.setPhone("9876543210");

        mineopsdao dao = new mineopsdao();
        dao.save(w);

        System.out.println("Worker inserted successfully!");
    }
}
