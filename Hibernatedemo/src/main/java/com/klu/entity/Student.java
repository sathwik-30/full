package com.klu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String dept;
    private double cgpa;         // <-- REQUIRED FIELD

    public Student() {}

    // include cgpa in constructor
    public Student(String name, int age, String dept, double cgpa) {
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.cgpa = cgpa;
    }

    // getters & setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
}
