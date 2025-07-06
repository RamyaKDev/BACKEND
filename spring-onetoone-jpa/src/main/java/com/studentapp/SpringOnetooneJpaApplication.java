package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.AddressDto;
import com.studentapp.model.StudentDto;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringOnetooneJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetooneJpaApplication.class, args);
	}
	
	@Autowired
	private IStudentService studentService;

	@Override
	public void run(String... args) throws Exception {

		// create address object
		AddressDto addressDto = new AddressDto("Cochin", null, "Kerala");
		// create student object
		StudentDto studentDto = new StudentDto("Peter", null, "EEE", addressDto);
		//studentService.addStudent(studentDto);
		
		
		System.out.println();
		System.out.println("Get All Students");
		studentService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get Student by Id");
		StudentDto nstudentDto= studentService.getById(151);
		System.out.println(nstudentDto);
		
		System.out.println();
		System.out.println("Update Student by Id");
		nstudentDto.setDepartment("IT");
		studentService.updateStudent(nstudentDto);
		nstudentDto= studentService.getById(151);
		System.out.println(nstudentDto);
		
		//studentService.deleteStudent(251);
		
		System.out.println();
		System.out.println("Get Students by department");
		studentService.getByDepartment("ECE").forEach(System.out::println);
		

		System.out.println();
		System.out.println("Get Students by state");
		studentService.getByState("Kerala").forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("Get Students by city");
		studentService.getByCity("Chennai").forEach(System.out::println);
	}

}
