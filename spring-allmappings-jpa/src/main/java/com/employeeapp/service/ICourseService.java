package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.CourseDto;



public interface ICourseService {
	void addCourse(CourseDto courseDto);
	void updateCourse(CourseDto courseDto);
	List<CourseDto> getAll();
	CourseDto getById(int courseId);
	void deleteById(int courseId);
}
