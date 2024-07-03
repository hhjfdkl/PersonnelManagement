package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.models.Office;
import com.skillstorm.repositories.OfficeRepository;

@Service
public class OfficeService {
	
	@Autowired
	private OfficeRepository repo;
	
	
	//CREATE functionality
	public ResponseEntity<Office> createOffice(Office office)
	{
		if(repo.existsById(office.getOfficeId()))
		{
			return ResponseEntity
					.status(400)
					.header("Error", "An office with this ID already exists")
					.body(office);
		}
		
		//checks name
		
		boolean match = office.getOfficeName().equals(repo.getOfficeNameByName(office.getOfficeName()));			//this will trip if a name matches
		
		
		if(match)
		{
			return ResponseEntity
					.status(400)
					.header("Error", "An office with this name already exists")
					.body(office);
		}
		
		return ResponseEntity
				.status(201)
				.header("Message", "Office created")
				.body(repo.save(office));
			
	}
	
	
	//READ functionality
	public ResponseEntity<Iterable<Office>> getAllOffices()
	{
		return ResponseEntity
				.status(200)
				.header("Message", "Successfully pulled all offices")
				.body(repo.findAll());
	}
	
	public ResponseEntity<Office> getOfficeById(int id)
	{
		if(!repo.existsById(id))
		{
			return ResponseEntity
					.status(404)
					.header("Error", "Unable to find office by ID provided - try again")
					.body(null);
		}
		return ResponseEntity
				.status(200)
				.header("Message", "Successfully pulled office by ID")
				.body(repo.findById(id).get());
	}
	
	
	//UPDATE functionality
	public ResponseEntity<Office> updateOffice(int id, String name, String address, String suite, String city, String state, int zip, int max, List<Employee> employees) //
	{
		if(!repo.existsById(id))
			{
				return ResponseEntity
						.status(404)
						.header("Error", "Unable to find office specified - try again")
						.body(null);
			}
		return ResponseEntity
				.status(200)
				.header("Message", "Office successfully updated")
				.body(repo.save(new Office(id, name, address, suite, city, state, zip, max, employees))); //
	}
	
	
	//DELETE functionality
	public ResponseEntity<Office> deleteOfficeById(int id)
	{
		if(!repo.existsById(id))
		{
			return ResponseEntity
					.status(404)
					.header("Error", "Unable to find office specified - try again")
					.body(null);
		}
		Office response = repo.findById(id).get();
		repo.deleteById(id);
		return ResponseEntity
				.status(200)
				.header("Message", "Job successfully deleted")
				.body(response);
	}

}
