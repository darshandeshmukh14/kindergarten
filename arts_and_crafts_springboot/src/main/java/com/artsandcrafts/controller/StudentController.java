package com.artsandcrafts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artsandcrafts.model.EnrolledCourse;
import com.artsandcrafts.model.Student;
import com.artsandcrafts.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
	    return studentService.addStudent(student);
	}

	@PutMapping("/addAdmission/{emailId}")
	public Student enrolleCourse(@PathVariable String emailId, @RequestBody Student student) {
	    return studentService.enrolleCourse(emailId, student);
	} 
	
	@GetMapping("/checkAdmission/{emailId}/{courseID}")
	public Boolean checkAdmission(@PathVariable String emailId, @PathVariable int courseID) {
	    Boolean bool =  studentService.checkAdmission(emailId, courseID);
	    if(bool) {
	    	return true;
	    }else {
	    	return false;
	    }
	} 
	
	@PutMapping("/editStudent/{studentId}")
	public Student editStudent(@PathVariable int studentId, @RequestBody Student student) {
	    return studentService.editStudent(studentId, student);
	}
	
	@GetMapping("/findByStudent/name/{firstName}")
    public List<Student> findByFirstName(@PathVariable String firstName) {
        return studentService.findByFirstName(firstName);
    }
	
	@GetMapping("/findStudent/{id}")
    public List<EnrolledCourse> findByStudentId(@PathVariable int id) {
        return studentService.findByStudentId(id);
    }
	
	@GetMapping("/findByStudent/{id}")
    public Student findByStudentIDs(@PathVariable int id) {
        return studentService.findByStudentIDs(id);
    }
	
	
	@GetMapping("/getStudentId/{email}")
    public Integer getStudentId(@PathVariable String email) {
        return studentService.getStudentId(email);
    }
	
	@GetMapping("/viewStudent")
	public List<Student> viewStudent() {
		return studentService.viewStudent();
	}
	
	@DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
	
	@GetMapping("/checkStudentMailId/{emailId}")
	public String emailValidation(@PathVariable String emailId) {
		Boolean bool = studentService.existsByEmailId(emailId);
		if(bool)
			return "true";
		else 
			return "false";  
    }

}
