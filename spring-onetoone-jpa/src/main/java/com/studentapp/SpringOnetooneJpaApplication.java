package com.studentapp;

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

	private IStudentService studentService;

	@Override
	public void run(String... args) throws Exception {

		AddressDto address = new AddressDto("Chennai", null, "TN");
		// create student object
		StudentDto studentDto = new StudentDto("Joe", null, "CSE", address);
		studentService.addStudent(studentDto);

	}

}
