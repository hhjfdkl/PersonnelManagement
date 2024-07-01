package com.skillstorm.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import com.skillstorm.services.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
		//CREATE
		@PostMapping
		public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
		{
			return service.createEmployee(employee);
		}
		
		
		//READ
		@GetMapping
		public ResponseEntity<Iterable<Employee>> getAllEmployees()
		{
			return service.getAllEmployees();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable int id)
		{
			return service.getEmployeeById(id);
		}
		
		
		//UPDATE
		@PutMapping
		public ResponseEntity<Employee> updateEmployee(
				@RequestParam int id,
				@RequestParam String firstName, 
				@RequestParam String lastName, 
				@RequestParam BigDecimal hourlyPay, 
				@RequestParam LocalDate hireDate, 
				@RequestParam Department department, 
				@RequestParam Office office, 
				@RequestParam Job job
		)
		{
			return service.updateEmployee(id, firstName, lastName, hourlyPay, hireDate, department, office, job);
		}
		
		
		//DELETE
		@DeleteMapping("/{id}")
		public void deleteEmployee(@RequestBody int id)
		{
			service.deleteEmployeeById(id);
		}
}
