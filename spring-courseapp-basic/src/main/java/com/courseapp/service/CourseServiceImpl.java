package com.courseapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.exception.CourseNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.util.CourseUtil;

@Service
public class CourseServiceImpl implements ICourseService {

	private CourseUtil courseutil;

	@Autowired
	public void setCourseutil(CourseUtil courseutil) {
		this.courseutil = courseutil;
	}

	@Override
	public List<Course> getAll() {
		return courseutil.getAllCourses();
	}

	@Override
	public Course getCourseById(int courseId) {
		List<Course> courses = courseutil.getAllCourses();
//	    List<Course> courses = courseUtil.getAllCourses();
//		Optional<Course> courseopt = courses.stream()
//					.filter(course->course.getCourseId()==courseId)
//					.findFirst();
//		if(courseopt.isPresent())
//			return courseopt.get();
//		return null;
		return courses.stream().filter(course -> course.getCourseId() == courseId).findFirst()
				.orElseThrow(() -> new CourseNotFoundException("invalid id"));
	}

	@Override
	public List<Course> CourseByType(String type) {
		List<Course> courses = courseutil.getAllCourses();
		List<Course> ncourses = courses.stream().filter(course -> course.getType().equals(type)).toList();
		if (ncourses.isEmpty())
			throw new CourseNotFoundException("type not found");
		return ncourses;

	}

	@Override
	public List<Course> getByLessDurationAndCost(int duration, int cost) {
		List<Course> courses = courseutil.getAllCourses();

		List<Course> ncourses = courses.stream()
				.filter(course -> (course.getCost() <= cost) && (course.getDurationInWeeks() <= duration)).toList();
		if (ncourses.isEmpty())
			throw new CourseNotFoundException("There is no course available in less duration and less cost");
		return ncourses;
	}

	@Override
	public List<String> getCourseName() {
		List<Course> courses = courseutil.getAllCourses();
		List<String> ncourses = courses.stream().map((course) -> course.getCourseName()).collect(Collectors.toList());

		if (ncourses.isEmpty())
			throw new CourseNotFoundException("No course available");
		return ncourses;
	}

}
