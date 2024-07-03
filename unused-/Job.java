package com.skillstorm.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private int jobId;
	
	@Column(name = "job_name")
	private String jobName;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("job")
	private List<Employee> employees;
	
	
	public Job()
	{
		super();
	}
	
	
	public Job(int jobId, String jobName, String jobDescription, List<Employee> employees)
	{
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.employees = employees;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobName() {
		return jobName;
	}


	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employees, jobDescription, jobId, jobName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(employees, other.employees) && Objects.equals(jobDescription, other.jobDescription)
				&& jobId == other.jobId && Objects.equals(jobName, other.jobName);
	}
	
}
