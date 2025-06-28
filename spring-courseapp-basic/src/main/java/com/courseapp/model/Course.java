package com.courseapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@Getter
//@Setter
//@ToString
public class Course {

	
	private String courseName;
	private Integer courseId;
	private String type; //backend, frontend, cloud,AI
	private double cost;
	private int durationInWeeks;
	
}
