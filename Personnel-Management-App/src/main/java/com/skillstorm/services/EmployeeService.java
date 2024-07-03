package com.skillstorm.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Department;
import com.skillstorm.models.Employee;
import com.skillstorm.models.Office;
import com.skillstorm.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	
	//CREATE functionality
		public ResponseEntity<Employee> createEmployee(Employee employee)
		{
			if(repo.existsById(employee.getEmployeeId()))
			{
				return ResponseEntity
						.status(400)
						.header("Error", "An employee with this ID already exists")
						.body(employee);
			}
			
			//this section is to confirm we can actually add the employee to the office
			int officeId = employee.getOffice().getOfficeId();
			int officeMaxCapacity = employee.getOffice().getMaxCapacity();
			int employeesAfterAddition = repo.getTotalEmployeesInOffice(officeId) + 1;
			if(employeesAfterAddition > officeMaxCapacity)
			{
				return ResponseEntity
						.status(400)
						.header("Error", "The office will exceed the max limit. Too many employees are here.")
						.body(employee);
			}
			
			return ResponseEntity
					.status(201)
					.header("Message", "Employee created")
					.body(repo.save(employee));
				
		}
		
		
		//READ functionality
		public ResponseEntity<Iterable<Employee>> getAllEmployees()
		{
			return ResponseEntity
					.status(200)
					.header("Message", "Successfully pulled all employees")
					.body(repo.findAll());
		}
		
		public ResponseEntity<Employee> getEmployeeById(int id)
		{
			if(!repo.existsById(id))
			{
				return ResponseEntity
						.status(404)
						.header("Error", "Unable to find employee by ID provided - try again")
						.body(null);
			}
			return ResponseEntity
					.status(200)
					.header("Message", "Successfully pulled employee by ID")
					.body(repo.findById(id).get());
		}
		
		
		//UPDATE functionality
		public ResponseEntity<Employee> updateEmployee(int id, String firstName, String lastName, Department department, Office office)
		{
			if(!repo.existsById(id))
				{
					return ResponseEntity
							.status(404)
							.header("Error", "Unable to find employee specified - try again")
							.body(null);
				}
			
			
			int officeId = office.getOfficeId();
			if(officeId != repo.getOfficeIdOfEmployee(id)) 
			{
				int officeMaxCapacity = office.getMaxCapacity();
				int employeesAfterAddition = repo.getTotalEmployeesInOffice(officeId) + 1;
				if(employeesAfterAddition > officeMaxCapacity)
				{
					return ResponseEntity
							.status(400)
							.header("Error", "The office will exceed the max limit. Too many employees are here.")
							.body(null);
				}
			}
			
			return ResponseEntity
					.status(200)
					.header("Message", "Employee successfully updated")
					.body(repo.save(new Employee(id, firstName, lastName, department, office)));
		}
		
		
		//DELETE functionality
		public ResponseEntity<Employee> deleteEmployeeById(int id)
		{
			if(!repo.existsById(id))
			{
				return ResponseEntity
						.status(404)
						.header("Error", "Unable to find employee specified - try again")
						.body(null);
			}
			Employee response = repo.findById(id).get();
			repo.deleteById(id);
			return ResponseEntity
					.status(200)
					.header("Message", "Employee successfully deleted")
					.body(response);
		}
}
