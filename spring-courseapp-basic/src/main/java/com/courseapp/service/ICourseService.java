package com.courseapp.service;

import java.util.List;

import com.courseapp.model.Course;

public interface ICourseService {

	List<Course> getAll();
	Course getCourseById(int CourseId);
	List<Course> CourseByType(String CourseType);
	List<Course> getByLessDurationAndCost(int duration,int cost);
	List<String> getCourseName();
}
