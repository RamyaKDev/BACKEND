package com.studentapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;
@Service
public class StudentServiceImpl implements IStudentService{

	
	@Autowired
	private ModelMapper mapper;
	private IStudentRepository studentRepository;
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
		List<Student> students = studentRepository.findAll();

		// System.out.println("CHECK-001");
		// students.forEach(System.out::println);
		return students.stream().map(student -> mapper.map(student, StudentDto.class))
				.sorted((s1, s2) -> s1.getStudentName().compareTo(s2.getStudentName())).toList();

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
		List<Student> students = studentRepository.findByAddressState(state);
		if (students.isEmpty())
			throw new StudentNotFoundException("Student not found");
		return students.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		List<Student> students = studentRepository.findByAddressCity(city);
		if (students.isEmpty())
			throw new StudentNotFoundException("Student not found");
		return students.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}

}
