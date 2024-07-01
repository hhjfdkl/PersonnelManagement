package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> 
{

}
