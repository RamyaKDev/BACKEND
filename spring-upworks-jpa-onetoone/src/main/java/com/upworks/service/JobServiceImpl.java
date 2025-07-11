package com.upworks.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upworks.exception.JobNotFoundException;
import com.upworks.model.Job;
import com.upworks.model.JobDto;
import com.upworks.repository.IJobRepository;

@Service
public class JobServiceImpl implements IJobService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IJobRepository jobRepository;

	@Override
	public void addJob(JobDto jobDto) {

		Job job = mapper.map(jobDto, Job.class);
		jobRepository.save(job);
	}

	@Override
	public void updateJob(JobDto jobDto) {
		Job job = mapper.map(jobDto, Job.class);
		jobRepository.save(job);

	}

	@Override
	public void deleteJob(int jobId) {
		jobRepository.deleteById(jobId);

	}

	@Override
	public List<JobDto> getAll() {
		List<Job> jobs = jobRepository.findAll();
		if (jobs.isEmpty())
			throw new JobNotFoundException("No job found");
		return jobs.stream().map(job -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public JobDto getById(int jobId) {
		Job job = jobRepository.findById(jobId).orElseThrow(() -> new JobNotFoundException("invalid id"));
		JobDto jobDto = mapper.map(job, JobDto.class);
		return jobDto;
	}

	@Override
	public List<JobDto> getByJobType(String jobType) {
		List<Job> jobs = jobRepository.findByJobType(jobType);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified jobType");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public List<JobDto> getByRole(String role) {
		List<Job> jobs = jobRepository.findByRole(role);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified role");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public List<JobDto> getByLocation(String location) {
		List<Job> jobs = jobRepository.findByLocation(location);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified location");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public List<JobDto> getByTypeandRole(String jobType, String role) {
		List<Job> jobs = jobRepository.findByTypeRole(jobType, role);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified jobType and role");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public List<JobDto> getByTypeandMode(String jobType, String mode) {
		List<Job> jobs = jobRepository.findByTypeMode(jobType, mode);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified jobType and mode");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public List<JobDto> getByLocationandType(String location, String jobType) {
		List<Job> jobs = jobRepository.findByLocationType(location, jobType);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified jobType and location");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

	@Override
	public List<JobDto> getByLocationandRole(String location, String role) {
		List<Job> jobs = jobRepository.findByLocationRole(location, role);
		if (jobs.isEmpty())
			throw new JobNotFoundException("There is no job in the specified location and role");
		return jobs.stream().map((job) -> mapper.map(job, JobDto.class)).toList();
	}

}
