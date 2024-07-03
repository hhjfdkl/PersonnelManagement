package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> 
{
	
	

	//check to make sure we're not exceeding the max capacity of the office (for our UPDATE and CREATE methods)
	//This method specifically grabs the total employees in the office
	@Query(
			value = 
			  "SELECT COUNT(*) "
			+ "FROM employees AS e "
			+ "JOIN offices AS o ON o.office_id = e.office_id "
			+ "WHERE e.office_id = ?1"
			, nativeQuery = true
	)
	public int getTotalEmployeesInOffice(int officeId);
	
	//used to check if our employee is already in this office
	//this is for our UPDATE method
	@Query (
			value = 
			  "SELECT office_id "
			+ "FROM employees "
			+ "WHERE employee_id = ?1"
			, nativeQuery = true
	)
	public int getOfficeIdOfEmployee(int employeeId);
}
