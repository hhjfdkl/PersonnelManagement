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
				
				//checks names
				List<String> names = repo.getJobNames();	//we get a list of Strings from DB
				boolean match = false;			//this will trip if a name matches
				for(String name : names)		//iterate and compare case insensitive to match the DB unique name constraint
					if(name.toLowerCase().equals(job.getJobName().toLowerCase()))
					{
						match = true;
						break;
					}
						
				
				if(match)
				{
					return ResponseEntity
							.status(400)
							.header("Error", "A job with this name already exists")
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
