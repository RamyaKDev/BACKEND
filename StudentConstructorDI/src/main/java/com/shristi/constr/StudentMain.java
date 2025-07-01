package com.shristi.constr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		//create the IOCContainer-
		//spring beans are created
		ApplicationContext context=new AnnotationConfigApplicationContext("com.shristi.constr");
		Student student=(Student) context.getBean("student");
		System.out.println(student);
	}

}
