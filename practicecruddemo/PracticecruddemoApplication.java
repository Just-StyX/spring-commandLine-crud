package com.practicedemo.practicecruddemo;

import com.practicedemo.practicecruddemo.dao.StudentDAO;
import com.practicedemo.practicecruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PracticecruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticecruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
//			findStudentById(studentDAO);
//			findStudentByLastName(studentDAO);
//			getNumberOfRows(studentDAO);
//			findStudentByIdAndUpdate(studentDAO);
//			findByIdAndDelete(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		studentDAO.deleteAll();
	}

	private void findByIdAndDelete(StudentDAO studentDAO) {
		studentDAO.findByIdAndDelete(2);
	}

	private void findStudentByIdAndUpdate(StudentDAO studentDAO) {
		Student student = studentDAO.findByIdAndUpdate(2, "John", ' ', "Isak", "Mathematics");
		System.out.println("---------------------------------------------------");
		System.out.println("Student updated successfully: " + student);
		System.out.println("---------------------------------------------------");
	}

	private void getNumberOfRows(StudentDAO studentDAO) {
		System.out.println("---------------------------------------------------");
		System.out.println("Total number of students: " + studentDAO.numberOfRows());
		System.out.println("---------------------------------------------------");
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findStudentByLastName("Jack");
		System.out.println("---------------------------------------------------");
		for (Student student: students) {
			System.out.println(
					"Student Info = " + student.getFirstName() +" "+ student.getLastName() +" "+ student.getProgramOfStudy()
			);
		}
		System.out.println("---------------------------------------------------");
	}

	private void findStudentById(StudentDAO studentDAO) {
		int studentID = 2;
		Student student = studentDAO.findById(studentID);
		System.out.println("---------------------------------------------------");
		System.out.println(
				"Student Info = " + student.getFirstName() +" "+ student.getLastName() +" "+ student.getProgramOfStudy()
		);
		System.out.println("---------------------------------------------------");
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Kennedy", 'K', "Agyapong", "Business");
		studentDAO.save(student);
		System.out.println("---------------------------------------------------");
		System.out.println("Student saved successfully: Student ID = " + student.getId());
		System.out.println("---------------------------------------------------");
	}

}
