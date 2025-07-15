package com.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exception.CourseNotFoundException;
import com.employeeapp.exception.DepartmentNotFoundException;
import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.model.Department;
import com.employeeapp.model.DepartmentDto;
import com.employeeapp.repository.ICourseRepository;
import com.employeeapp.repository.IDepartmentRepository;




@Service
public class DepartmentServiceImpl implements IDepartmentService{
	@Autowired
	private IDepartmentRepository departmentRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public void addDepartment(DepartmentDto departmentDto) {
		Department department=mapper.map(departmentDto, Department.class);
		departmentRepository.save(department);
		
	}
	
	


	@Override
	public void updateDepartment(DepartmentDto departmentDto) {
		Department department=mapper.map(departmentDto, Department.class);
		departmentRepository.save(department);
		
	}

	@Override
	public List<DepartmentDto> getAll() {
		List<Department> departments=departmentRepository.findAll();
		if(departments.isEmpty())
			throw new DepartmentNotFoundException("No departments");
		return departments.stream()
				.map(department->mapper.map(department,DepartmentDto.class))
				.toList();
	}

	@Override
	public DepartmentDto getById(int departmentId) {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(()-> new DepartmentNotFoundException("invalid department id"));
			
		return mapper.map(department, DepartmentDto.class);
	}

	@Override
	public void deleteById(int departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

	

	

	

}
