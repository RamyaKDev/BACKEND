package com.shristi.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:application.properties")
public class Student {
	private String studentName;
	private int studentId;
	private String city;
	private Department department;
	//For Constructor based DI no need to provide @Autowired

	public Student(Department department) {
		super();
		this.department = department;
	}

	
	public String getStudentName() {
		return studentName;
	}

	@Value("${student.studentName}")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getStudentId() {
		return studentId;
	}

	@Value("${student.studentId}")
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getCity() {
		return city;
	}

	@Value("${student.city}")
	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", city=" + city + ", department="
				+ department + "]";
	}
}
