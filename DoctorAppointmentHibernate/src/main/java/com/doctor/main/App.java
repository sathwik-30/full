package com.doctor.main;

import java.time.LocalDateTime;
import java.util.List;

import com.doctor.dao.PatientDAO;
import com.doctor.entity.Patient;

public class App 
{
    public static void main(String[] args) 
    {
        PatientDAO dao = new PatientDAO();
        // INSERT
        Patient p = new Patient();
        p.setPatientName("Sathwik");
        p.setMobileNo("9392951277");
        p.setEmailId("sathwik@gmail.com");
        p.setAddress("Nellore");
        p.setBookingDatetime(LocalDateTime.now());
        dao.savePatient(p);
        System.out.println("Patient inserted");
        // READ
        List<Patient> list = dao.getAllPatients();
        for (Patient pt : list) 
        {
            System.out.println(pt.getPatientId() + " " + pt.getPatientName());
        }
    }
}