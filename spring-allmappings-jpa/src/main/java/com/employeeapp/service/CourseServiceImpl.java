package com.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exception.CourseNotFoundException;
import com.employeeapp.model.Course;
import com.employeeapp.model.CourseDto;
import com.employeeapp.repository.ICourseRepository;




@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private ICourseRepository courseRepository;
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public void addCourse(CourseDto courseDto) {
		Course course=mapper.map(courseDto, Course.class);
		courseRepository.save(course);
		
	}
	
	


	@Override
	public void updateCourse(CourseDto courseDto) {
		Course course=mapper.map(courseDto, Course.class);
		courseRepository.save(course);
		
	}

	@Override
	public List<CourseDto> getAll() {
		List<Course> courses=courseRepository.findAll();
		if(courses.isEmpty())
			throw new CourseNotFoundException("No courses");
		return courses.stream()
				.map(course->mapper.map(course,CourseDto.class))
				.toList();
	}

	@Override
	public CourseDto getById(int courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(()-> new CourseNotFoundException("invalid course id"));
		System.out.println(course);
		CourseDto courseDto =  new CourseDto();
		courseDto.setCourseId(courseId);
		courseDto.setCourseName(course.getCourseName());
		courseDto.setMode(course.getMode());
		courseDto.setType(course.getType());
		courseDto.setFees(course.getFees());
		
		return courseDto;
	}

	@Override
	public void deleteById(int courseId) {
		courseRepository.deleteById(courseId);
		
	}

	

	

	

}
