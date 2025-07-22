package com.upwork.service;

import java.util.List;

import com.upwork.model.JobDto;



public interface IJobService {
	void addJob(JobDto jobDto);

	void updateJob(JobDto jobDto);

	void deleteJob(int jobId);

	List<JobDto> getAll();

	JobDto getById(int jobId);

	List<JobDto> getByJobType(String jobType);

	List<JobDto> getByRole(String role);

	List<JobDto> getByLocation(String location);

	List<JobDto> getByTypeandRole(String jobType, String role);

	List<JobDto> getByTypeandMode(String jobType, String mode);

	List<JobDto> getByLocationandType(String location, String jobType);

	List<JobDto> getByLocationandRole(String location, String role);
}
