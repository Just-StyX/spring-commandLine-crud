package com.practicedemo.practicecruddemo.dao;

import com.practicedemo.practicecruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplement implements StudentDAO{

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        String sql = "FROM Student WHERE lastName=:theData";
        TypedQuery<Student> students = entityManager.createQuery(sql, Student.class);
        students.setParameter("theData", lastName);
        return students.getResultList();
    }

    @Override
    public int numberOfRows() {
        String sql = "FROM Student";
        TypedQuery<Student> students = entityManager.createQuery(sql, Student.class);
        return students.getResultList().size();
    }

    @Override
    @Transactional
    public Student findByIdAndUpdate(int id, String firstName, char MI, String lastName, String program) {
        Student student = findById(id);
        student.setMI(MI);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setProgramOfStudy(program);

        entityManager.merge(student);
        return student;
    }

    @Override
    @Transactional
    public void findByIdAndDelete(int id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
