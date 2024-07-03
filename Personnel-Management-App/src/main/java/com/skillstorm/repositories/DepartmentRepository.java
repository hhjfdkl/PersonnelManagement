package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Department;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Integer>
{
	
	//grabs all names (if needed)
		@Query(
				value =
				  "SELECT department_name "
				+ "FROM departments"
				, nativeQuery = true		
		)
		public List<String> getDepartmentNames();
		
		//grabs one name (to compare on creation)
		@Query(
				value = 
				  "SELECT department_name "
				+ "FROM departments "
				+ "WHERE department_name LIKE ?1"
				, nativeQuery = true
		)
		public String getDepartmentNameByName(String name);
		
		@Query(
				value = 
				  "SELECT department_name "
				+ "FROM departments "
				+ "WHERE department_id = ?1"
				, nativeQuery = true
		)
		public String getDepartmentNameById(int id);
}
