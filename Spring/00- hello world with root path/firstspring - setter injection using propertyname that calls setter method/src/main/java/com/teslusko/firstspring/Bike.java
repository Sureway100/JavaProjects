package com.teslusko.firstspring;

import org.springframework.stereotype.Component;

//public class Bike {
//	public void drive() {
//		System.out.println("sounds like cha lo bam");
//	}
//
//}


//because we use interface now

@Component
public class Bike implements Vehicle {
	public void drive() {
		System.out.println("bike sounds like cha lo bam");
	}
}