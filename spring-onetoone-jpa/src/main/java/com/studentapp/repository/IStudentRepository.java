package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
//Derived Query
	List<Student> findByDepartment(String department);
	
	//custom query
	@Query("from Student s inner join s.address a where a.city=?1")
	List<Student> findByAddressCity(String city);
	
	
	@Query("from Student s inner join s.address a where a.state=?1")
	List<Student> findByAddressState(String state);
}
