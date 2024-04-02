package com.zeno.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeno.springdemo.entity.Student;

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
	
	// endpoint to get all students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
			
		return theStudents;
	}
	
	//endpoint to get one student id
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
			
		return theStudents.get(studentId);
	}

}
