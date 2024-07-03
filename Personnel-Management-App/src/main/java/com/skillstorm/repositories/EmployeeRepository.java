package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> 
{
	//we should probably put a check against office capacity either here or in office repository to check against max capacity
	
	
	@Query(
			value = 
			  "SELECT first_name "
			+ "FROM employees "
			+ "WHERE employee_id = ?1"
			, nativeQuery = true
	)
	public String getEmployeeFirstNameById(int id);
	
	@Query(
			value = 
			  "SELECT last_name "
			+ "FROM employees "
			+ "WHERE employee_id = ?1"
			, nativeQuery = true
	)
	public String getEmployeeLastNameById(int id);
}
