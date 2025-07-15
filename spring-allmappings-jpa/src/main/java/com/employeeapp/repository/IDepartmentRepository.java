package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.model.Course;
import com.employeeapp.model.Department;


public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

}
