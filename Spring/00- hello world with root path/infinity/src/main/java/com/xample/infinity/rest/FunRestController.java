package com.xample.infinity.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	//expose "/" that returns "hello world"
	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}
	
	//end point for working out
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "run a hard 5km";
	}
}
