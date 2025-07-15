package com.employeeapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.AddressDto;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.DepartmentDto;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.model.InsuranceDto;
import com.employeeapp.model.MODE;
import com.employeeapp.model.TYPE;
import com.employeeapp.service.ICourseService;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringAllmappingsJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringAllmappingsJpaApplication.class, args);
	}
	@Autowired
	private ICourseService courseService;
	@Autowired
	private IEmployeeService employeeService;
	@Override
	public void run(String... args) throws Exception {
		AddressDto address =  new AddressDto("Cochin",null,"Kerala");
		DepartmentDto department =  new DepartmentDto("Marketing");
		
		InsuranceDto insurance1  =  new InsuranceDto("LICKids", null, "LIC","Kids", 10000);
		InsuranceDto insurance2  =  new InsuranceDto("StarOne", null, "Star","health", 10000);
		InsuranceDto insurance3  =  new InsuranceDto("VoyaEx", null, "Voya","vehicle", 10000);
		Set<InsuranceDto> insuranceDtos = new HashSet<>(Arrays.asList(insurance1,insurance2,insurance3));
		

		//create the coursedto object
		CourseDto course1 = new CourseDto("JFS", null, 2000,"Technical","Online");
		CourseDto course2 = new CourseDto("DataScience", null, 3000,"Technical","Online");
		CourseDto course3 = new CourseDto("Leadership", null, 5600,"Softskills","Offline");
		//create the set of courses
		Set<CourseDto> courseDtos1 = new HashSet<>(Arrays.asList(course1,course2,course3));
		
		Set<String> hobbies =  new HashSet<>(Arrays.asList("Sports","Music"));
			
		//create the employeedto object and add the set of courses
		EmployeeDto employee1 = 
				new EmployeeDto("Rakesh",null,address,insuranceDtos,department,courseDtos1,hobbies);
		//save the object
		employeeService.addEmployee(employee1);
		
		
		
	}

}
