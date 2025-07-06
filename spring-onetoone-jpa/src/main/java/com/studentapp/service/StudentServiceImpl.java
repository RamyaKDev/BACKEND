package com.studentapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;
@Service
public class StudentServiceImpl implements IStudentService{

	private IStudentRepository studentRepository;
	@Autowired
	private ModelMapper mapper;
	public StudentServiceImpl(IStudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public void addStudent(StudentDto studentDto) {
		 Student product = mapper.map(studentDto,Student.class);
		studentRepository.save(product);
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		Student product = mapper.map(studentDto,  Student.class);
		studentRepository.save(product);
		
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		
	}

	@Override
	public List<StudentDto> getAll() {
		List<Student> students=studentRepository.findAll();
		return students.stream()
				.map(student->mapper.map(student,StudentDto.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public StudentDto getById(int studentId) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("invalid id"));
		StudentDto studentDto = mapper.map(student, StudentDto.class);
		return studentDto;
	}

	@Override
	public List<StudentDto> getByDepartment(String department) {
		List<Student> students = studentRepository.findByDepartment(department);
		if (students.isEmpty())
			throw new StudentNotFoundException("Student not found");
		return students.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> getByState(String state) {
		List<Student> students = studentRepository.findByDepartment(state);
		if (students.isEmpty())
			throw new StudentNotFoundException("Student not found");
		return students.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> getByCity(String state) {
		List<Student> students = studentRepository.findByDepartment(state);
		if (students.isEmpty())
			throw new StudentNotFoundException("Student not found");
		return students.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

}
