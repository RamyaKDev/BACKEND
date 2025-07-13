package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.EmployeeDto;

public interface IEmployeeService {
	//Crud operations
	void addEmployee(EmployeeDto employeeDto);
	void updateEmployee(EmployeeDto employeeDto);
	List<EmployeeDto> getAll();
	EmployeeDto getById(int employeeId);
	void deleteById(int employeeId);
	
	
	
}
