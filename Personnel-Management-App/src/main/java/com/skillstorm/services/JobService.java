package com.skillstorm.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.models.Job;
import com.skillstorm.models.Office;
import com.skillstorm.repositories.JobRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository repo;
	
	
	
	//CREATE functionality
			public ResponseEntity<Job> createJob(Job job)
			{
				if(repo.existsById(job.getJobId()))
				{
					return ResponseEntity
							.status(400)
							.header("Error", "A job with this ID already exists")
							.body(job);
				}
				
				return ResponseEntity
						.status(201)
						.header("Message", "Job created")
						.body(repo.save(job));
					
			}
			
			
			//READ functionality
			public ResponseEntity<Iterable<Job>> getAllJobs()
			{
				return ResponseEntity
						.status(200)
						.header("Message", "Successfully pulled all jobs")
						.body(repo.findAll());
			}
			
			public ResponseEntity<Job> getJobById(int id)
			{
				if(!repo.existsById(id))
				{
					return ResponseEntity
							.status(404)
							.header("Error", "Unable to find job by ID provided - try again")
							.body(null);
				}
				return ResponseEntity
						.status(200)
						.header("Message", "Successfully pulled job by ID")
						.body(repo.findById(id).get());
			}
			
			
			//UPDATE functionality
			public ResponseEntity<Job> updateJob(int id, String name, String description, List<Employee> employees)
			{
				if(!repo.existsById(id))
					{
						return ResponseEntity
								.status(404)
								.header("Error", "Unable to find job specified - try again")
								.body(null);
					}
				return ResponseEntity
						.status(200)
						.header("Message", "Job successfully updated")
						.body(repo.save(new Job(id, name, description, employees)));
			}
			
			
			//DELETE functionality
			public ResponseEntity<Job> deleteJobById(int id)
			{
				if(!repo.existsById(id))
				{
					return ResponseEntity
							.status(404)
							.header("Error", "Unable to find job specified - try again")
							.body(null);
				}
				Job response = repo.findById(id).get();
				repo.deleteById(id);
				return ResponseEntity
						.status(200)
						.header("Message", "Job successfully deleted")
						.body(response);
			}

}
