package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Department;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Integer>
{
	
	//method to get names so we can ensure the server doesn't crash if duplicate name is entered
		@Query(
				value =
				  "SELECT department_name "
				+ "FROM departments"
				, nativeQuery = true		
		)
		public List<String> getDepartmentNames();
}
