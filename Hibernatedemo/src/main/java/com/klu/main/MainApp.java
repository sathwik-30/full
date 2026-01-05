package com.klu.main;

import com.klu.dao.StudentDAO;
import com.klu.entity.Student;

public class MainApp {

    public static void main(String[] args) {

    	StudentDAO dao = new StudentDAO();

    	// CREATE
    	Student s1 = new Student("Sathwik", 7, "CSE", 8.9);
    	dao.saveStudent(s1);

    	// READ
    	Student s = dao.getStudent(1);
    	System.out.println("Fetched: " + s.getName() + " - " + s.getDept());

    	// UPDATE
    	s.setAge(19);
    	s.setDept("AI");
    	dao.updateStudent(s);

 

    }
}
