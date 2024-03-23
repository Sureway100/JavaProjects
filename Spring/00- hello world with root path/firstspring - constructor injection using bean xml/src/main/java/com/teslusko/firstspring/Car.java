package com.teslusko.firstspring;

import org.springframework.stereotype.Component;

//public class Car {
//	public void drive() {
//		System.out.println("sounds like cha lo bam");
//	}
//}


//because we use interface now
@Component
public class Car implements Vehicle {
	public void drive() {
		System.out.println("Car sounds like cha lo bam");
	}
}