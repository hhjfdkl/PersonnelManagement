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
import com.skillstorm.services.OfficeService;

@RestController
@RequestMapping("/office")
@CrossOrigin(origins = "*")
public class OfficeController {

	@Autowired
	private OfficeService service;
	
	
	//CREATE
	@PostMapping
	public ResponseEntity<Office> addOffice(@RequestBody Office office)
	{
		return service.createOffice(office);
	}
	
	
	//READ
	@GetMapping
	public ResponseEntity<Iterable<Office>> getAllOffices()
	{
		return service.getAllOffices();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Office> getOfficeById(@PathVariable int id)
	{
		return service.getOfficeById(id);
	}
	
	
	//UPDATE
	@PutMapping
	public ResponseEntity<Office> updateOffice(
			@RequestParam int id,
			@RequestParam String name, 
			@RequestParam String address, 
			@RequestParam String suite, 
			@RequestParam String city, 
			@RequestParam String state, 
			@RequestParam String country, 
			@RequestParam int max, 
			@RequestParam List<Employee> employees, 
			@RequestParam List<Department> departments
	)
	{
		return service.updateOffice(id, name, address, suite, city, state, country, max, employees, departments);
	}
	
	
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteOffice(@RequestBody int id)
	{
		service.deleteOfficeById(id);
	}
}
