package com.kindergarten.service;

import java.util.List;

import com.kindergarten.model.EnrolledCourse;
import com.kindergarten.model.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student editStudent(int studentId, Student student);

	List<Student> findByFirstName(String firstName);

	List<EnrolledCourse> findByStudentId(int id);

	List<Student> viewStudent();

	String deleteStudent(int id);

	Boolean existsByEmailId(String emailId);

	Student enrolleCourse(String emailId, Student student);

	Integer getStudentId(String email);

	Boolean checkAdmission(String emailId, int courseID);

	Student findByStudentIDs(int id);

}
