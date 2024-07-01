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
import com.skillstorm.models.Office;
import com.skillstorm.services.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "*")
public class DepartmentController {

	
	@Autowired
	private DepartmentService service;
	
	
	//CREATE
		@PostMapping
		public ResponseEntity<Department> addDepartment(@RequestBody Department department)
		{
			return service.createDepartment(department);
		}
		
		
		//READ
		@GetMapping
		public ResponseEntity<Iterable<Department>> getAllDepartments()
		{
			return service.getAllDepartments();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Department> getDepartmentById(@PathVariable int id)
		{
			return service.getDepartmentById(id);
		}
		
		
		//UPDATE
		@PutMapping
		public ResponseEntity<Department> updateDepartment(
				@RequestParam int id,
				@RequestParam String name, 
				@RequestParam List<Employee> employees, 
				@RequestParam List<Office> offices
		)
		{
			return service.updateDepartment(id, name, employees, offices);
		}
		
		
		//DELETE
		@DeleteMapping("/{id}")
		public void deleteDepartment(@RequestBody int id)
		{
			service.deleteDepartmentById(id);
		}
}
