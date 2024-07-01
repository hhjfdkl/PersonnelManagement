package com.skillstorm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.models.Office;
import com.skillstorm.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repo;
	
	
	//CREATE functionality
	public ResponseEntity<Department> createDepartment(Department department)
	{
		if(repo.existsById(department.getDepartmentId()))
		{
			return ResponseEntity
					.status(400)
					.header("Error", "A department with this ID already exists")
					.body(department);
		}
		
		//checks names
				List<String> names = repo.getDepartmentNames();	//we get a list of Strings from DB
				boolean match = false;			//this will trip if a name matches
				for(String name : names)		//iterate and compare case insensitive to match the DB unique name constraint
					if(name.toLowerCase().equals(department.getDepartmentName().toLowerCase()))
						match = true;
				
				if(match)
				{
					return ResponseEntity
							.status(400)
							.header("Error", "A department with this name already exists")
							.body(department);
				}
		
		return ResponseEntity
				.status(201)
				.header("Message", "Department created")
				.body(repo.save(department));
			
	}
	
	
	//READ functionality
	public ResponseEntity<Iterable<Department>> getAllDepartments()
	{
		return ResponseEntity
				.status(200)
				.header("Message", "Successfully pulled all departments")
				.body(repo.findAll());
	}
	
	public ResponseEntity<Department> getDepartmentById(int id)
	{
		if(!repo.existsById(id))
		{
			return ResponseEntity
					.status(404)
					.header("Error", "Unable to find department by ID provided - try again")
					.body(null);
		}
		return ResponseEntity
				.status(200)
				.header("Message", "Successfully pulled department by ID")
				.body(repo.findById(id).get());
	}
	
	
	//UPDATE functionality
	public ResponseEntity<Department> updateDepartment(int id, String name, List<Employee> employees, List<Office> offices) 
	{
		if(!repo.existsById(id))
			{
				return ResponseEntity
						.status(404)
						.header("Error", "Unable to find department specified - try again")
						.body(null);
			}
		return ResponseEntity
				.status(200)
				.header("Message", "Department successfully updated")
				.body(repo.save(new Department(id, name, employees, offices)));
	}
	
	
	//DELETE functionality
	public ResponseEntity<Department> deleteDepartmentById(int id)
	{
		if(!repo.existsById(id))
		{
			return ResponseEntity
					.status(404)
					.header("Error", "Unable to find department specified - try again")
					.body(null);
		}
		Department response = repo.findById(id).get();
		repo.deleteById(id);
		return ResponseEntity
				.status(200)
				.header("Message", "Department successfully deleted")
				.body(response);
	}
	
}
