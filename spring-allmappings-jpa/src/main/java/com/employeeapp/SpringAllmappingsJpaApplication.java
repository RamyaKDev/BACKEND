package com.employeeapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.CourseDto;
import com.employeeapp.model.EmployeeDto;
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
		//create the coursedto object
		CourseDto course1=new CourseDto("JFS",null,5000,TYPE.TECHNICAL.name(),MODE.ONLINE.name(),null);		
		CourseDto course2=new CourseDto("DataScience",null,3000,TYPE.TECHNICAL.name(),MODE.ONLINE.name(),null);		
		CourseDto course3=new CourseDto("Leadership",null,2000,TYPE.SOFTSKILL.name(),MODE.OFFLINE.name(),null);
		courseService.addCourse(course3);
		
		//create set of courses
		Set<CourseDto> courseDtos1=new HashSet<>(Arrays.asList(course1,course2));
		//create employee object and set of courses
		
		EmployeeDto employee1=new EmployeeDto("Rakesh",null,courseDtos1);
		employeeService.addEmployee(employee1);
		
		//courses already saved in db using 1st 3 lines. Now by id retrieving and adding course to employee
		CourseDto ncourse1=courseService.getById(51);
		CourseDto ncourse2=courseService.getById(52);
		CourseDto ncourse3=courseService.getById(53);
		
		courseDtos1=new HashSet<>(Arrays.asList(ncourse1,ncourse2,ncourse3));
		employee1=new EmployeeDto("James",null,courseDtos1);
		employeeService.addEmployee(employee1);
		
		courseDtos1=new HashSet<>(Arrays.asList(ncourse3));
		employee1=new EmployeeDto("Robert",null,courseDtos1);
		employeeService.addEmployee(employee1);
		
	}

}
