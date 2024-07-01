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
	@PutMapping("/{id}")
	public ResponseEntity<Office> updateOffice(
			@PathVariable int id,
			@RequestBody Office office
	)
	{
		return service.updateOffice(
				id, 
				office.getOfficeName(), 
				office.getAddress(), 
				office.getSuite(), 
				office.getCity(), 
				office.getState(), 
				office.getCountry(), 
				office.getMaxCapacity(), 
				office.getEmployees(), 
				office.getDepartments());
	}
	
	//due to foreign key constraints, we can't delete properly. Needs a try catch
	//DELETE
	@DeleteMapping("/{id}")
	public void deleteOffice(@PathVariable int id)
	{
		service.deleteOfficeById(id);
	}
}
