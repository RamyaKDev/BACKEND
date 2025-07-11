package com.upworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upworks.model.Job;

public interface IJobRepository extends JpaRepository<Job, Integer> {

	// Derived Query
	List<Job> findByLocation(String location);

	// custom Query
	@Query("from Job j inner join j.feature f where f.jobType=?1")
	List<Job> findByJobType(String jobType);

	@Query("from Job j inner join j.feature f where f.role=?1")
	List<Job> findByRole(String role);

	@Query("from Job j inner join j.feature f  where f.jobType= :fjobtype and f.role= :frole")
	List<Job> findByTypeRole(@Param("fjobtype") String jobType, @Param("frole") String role);

	@Query("from Job j inner join j.feature f  where f.jobType= :fjobtype and f.mode= :fmode")
	List<Job> findByTypeMode(@Param("fjobtype") String jobType, @Param("fmode") String mode);

	@Query("from Job j inner join j.feature f where j.location=?1 and f.jobType=?2")
	List<Job> findByLocationType(String location, String jobType);

	@Query("from Job j inner join j.feature f where j.location=?1 and f.role=?2 ")
	List<Job> findByLocationRole(String location, String role);
}
