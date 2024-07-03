package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> 
{
	//method to get names so we can ensure the server doesn't crash if duplicate name is entered
		@Query(
				value =
				  "SELECT job_name "
				+ "FROM jobs"
				, nativeQuery = true		
		)
		public List<String> getJobNames();
}
