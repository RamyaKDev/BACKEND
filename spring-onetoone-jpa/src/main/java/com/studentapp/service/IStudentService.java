package com.studentapp.service;

import java.util.List;

import com.studentapp.model.StudentDto;

public interface IStudentService {
	//CRUD operation
	void addStudent(StudentDto student);

	void updateStudent(StudentDto student);

	void deleteStudent(int studentId);

	List<StudentDto> getAll();

	StudentDto getById(int productId);
	
	List<StudentDto> getByDepartment(String department);
	List<StudentDto> getByState(String state);
	List<StudentDto> getByCity(String city);

}
