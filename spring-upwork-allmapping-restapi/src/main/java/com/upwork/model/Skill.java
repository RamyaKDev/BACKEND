package com.upwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Skill {
	@Id
	@GeneratedValue(generator="skill_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "skill_gen",sequenceName = "skill_seq",initialValue = 201,allocationSize = 1)
	private Integer skillId;
	private String skillName; //java, aws,  

}
