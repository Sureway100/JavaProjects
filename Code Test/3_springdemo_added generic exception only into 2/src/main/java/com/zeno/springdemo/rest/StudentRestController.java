package com.zeno.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeno.springdemo.entity.Student;
import com.zeno.springdemo.exception.StudentErrorResponse;
import com.zeno.springdemo.exception.StudentNotFoundException;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define post construct to load the  student data.... only once
	
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("henry", "chime"));
		theStudents.add(new Student("mark", "smith"));
		theStudents.add(new Student("ken", "mikel"));
	}
	
	
	
	//  (1)  endpoint to get all students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
			
		return theStudents;
	}
	
	
	
	//   (2)   endpoint to get one student id
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		if((studentId >= theStudents.size()) || (studentId < 0)){
			throw new StudentNotFoundException("student id not found - " + studentId);
		}
			
		return theStudents.get(studentId);
	}
	
	//   (3) add a custom (student not found)  exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		//create a studentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
	}
	
	//// add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		//create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	

}
