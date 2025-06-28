package com.courseapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.courseapp.model.Course;
import com.courseapp.model.CourseType;

@Component
public class CourseUtil {
	public List<Course> getAllCourses() {
		return Arrays.asList(new Course("Java", 1, CourseType.BACKEND.name(), 2000, 4),
				new Course("Spring", 2, CourseType.BACKEND.name(), 5000, 5),
				new Course("React", 3, CourseType.FRONTEND.name(), 6000, 4),
				new Course("Python", 4, CourseType.AI.name(), 5000, 3),
				new Course("AWS", 5, CourseType.CLOUDCOMPUTING.name(), 12000, 5),
				new Course("GCP", 6, CourseType.CLOUDCOMPUTING.name(), 14000, 10),
				new Course("AZURE", 7, CourseType.CLOUDCOMPUTING.name(), 13000, 10),
				new Course("Microservices", 8, CourseType.BACKEND.name(), 10000, 6));

	}
}
