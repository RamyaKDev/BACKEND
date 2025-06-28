package com.courseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.courseapp.service.ICourseService;

@SpringBootApplication
public class SpringCourseappBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseappBasicApplication.class, args);
	}
	@Autowired
	private ICourseService iCourseService;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("********Listing all the courses********");
		iCourseService.getAll().forEach(System.out::println);
		System.out.println("********Listing the course by ID********");
		System.out.println(iCourseService.getCourseById(1));
		System.out.println("********Listing the course by Type********");
		iCourseService.CourseByType("BACKEND").forEach(System.out::println);
		System.out.println("********Listing the course by less duration and cost********");
		System.out.println(iCourseService.getByLessDurationAndCost(10, 10000));
		System.out.println("********Listing the coursenames alone********");
		System.out.println(iCourseService.getCourseName());
	}

}
