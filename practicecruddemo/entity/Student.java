package com.practicedemo.practicecruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_base")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "MI")
    private char MI;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "programe_of_study")
    private String programOfStudy;

    public Student() {}

    public Student(String firstName, char MI, String lastName, String programOfStudy) {
        this.firstName = firstName;
        this.MI = MI;
        this.lastName = lastName;
        this.programOfStudy = programOfStudy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMI() {
        return MI;
    }

    public void setMI(char MI) {
        this.MI = MI;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProgramOfStudy() {
        return programOfStudy;
    }

    public void setProgramOfStudy(String programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", MI=" + MI +
                ", lastName='" + lastName + '\'' +
                ", programOfStudy='" + programOfStudy + '\'' +
                '}';
    }
}
