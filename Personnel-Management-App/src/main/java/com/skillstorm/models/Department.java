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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	//putting this here since it makes sense to be able to grab all employees that belong to this department
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("department")
	private List<Employee> employees;
	
	@ManyToMany(mappedBy = "departments")
	@JsonIgnoreProperties("departments")
	private List<Office> offices;

	
	public Department()
	{
		super();
	}
	
	public Department(int departmentId, String departmentName, List<Employee> employees, List<Office> offices)
	{
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.employees = employees;
		this.offices = offices;
	}
	
	
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Office> getOffices() {
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

	
	@Override
	public String toString() {
		return "Job [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(departmentId, departmentName, employees, offices);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return departmentId == other.departmentId && Objects.equals(departmentName, other.departmentName)
				&& Objects.equals(employees, other.employees) && Objects.equals(offices, other.offices);
	}

}
