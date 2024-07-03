package com.skillstorm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Office;

@Repository
public interface OfficeRepository extends CrudRepository<Office, Integer> 
{
	//method to get names so we can ensure the server doesn't crash if duplicate name is entered
	@Query(
			value =
			  "SELECT office_name "
			+ "FROM offices"
			, nativeQuery = true		
	)
	public List<String> getOfficeNames();
	
	@Query(
			value = 
			  "SELECT office_name "
			+ "FROM offices "
			+ "WHERE office_name LIKE ?1"
			, nativeQuery = true
	)
	public String getOfficeNameByName(String name);
	
	@Query(
			value = 
			  "SELECT office_name "
			+ "FROM offices "
			+ "WHERE office_id = ?1"
			, nativeQuery = true
	)
	public String getOfficeNameById(int id);
	
	
	
	
}
