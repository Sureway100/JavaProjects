package com.zeno.springdemo.exception;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
