package com.teslusko.firstspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Car obj = new Car();
//    	obj.drive();
    	
    	// so because we use  interface now, we only worry about the right 
    	//side of the object and not the ref variable;
    	//either to  Car or Bike.... But we dont want to manually do these, we want spring to auto help
    	//we would use getBean => either with BeanFactory or ApplicationContext
    	
    	Vehicle obj1 = new Car();
    	obj1.drive();
    	
    	Vehicle obj2 = new Bike();
    	obj2.drive();
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	Vehicle objA = (Vehicle) context.getBean("car");
    	objA.drive();
    	
    }
}
