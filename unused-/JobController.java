package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.models.Job;
import com.skillstorm.models.Office;
import com.skillstorm.services.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "*")
public class JobController {

	@Autowired
	private JobService service;
	
	//CREATE
		@PostMapping
		public ResponseEntity<Job> addJob(@RequestBody Job job)
		{
			return service.createJob(job);
		}
	
		
		//READ
		@GetMapping
		public ResponseEntity<Iterable<Job>> getAllJobs()
		{
			return service.getAllJobs();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Job> getJobById(@PathVariable int id)
		{
			return service.getJobById(id);
		}
		
		
		//UPDATE
		@PutMapping("/{id}")
		public ResponseEntity<Job> updateJob(
				@PathVariable int id,
				@RequestBody Job job				
		)
		{
			return service.updateJob(id, job.getJobName(), job.getJobDescription(), job.getEmployees());
		}
		
		
		//doesnt work now due to FK dependencies
		//DELETE
		
		@DeleteMapping("/{id}")
		public void deleteJob(@PathVariable int id)
		{
			service.deleteJobById(id);
		}
}
