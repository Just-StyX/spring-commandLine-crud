package com.practicedemo.practicecruddemo.dao;

import com.practicedemo.practicecruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findStudentByLastName(String lastName);
    int numberOfRows();
    Student findByIdAndUpdate(int id, String firstName, char MI, String lastName, String program);
    void findByIdAndDelete(int id);
    void deleteAll();
}
