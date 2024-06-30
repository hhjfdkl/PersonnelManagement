package com.skillstorm.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "hourly_pay")
	private BigDecimal hourlyPay;
	
	@Column(name = "hire_date")
	private LocalDate hireDate;
	
	//This will get the department this employee belongs to
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "department_id")
	@JsonIgnoreProperties("employees")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "office_id", referencedColumnName = "office_id")
	@JsonIgnoreProperties("employees")
	private Office office;
	
	@ManyToOne
	@JoinColumn(name = "job_id", referencedColumnName = "job_id")
	@JsonIgnoreProperties("employees")
	private Job job;

	
	public Employee()
	{
		super();
	}
	
	public Employee(int employeeId, String firstName, String lastName, BigDecimal hourlyPay, LocalDate hireDate, Department department, Office office, Job job)
	{
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyPay = hourlyPay;
		this.hireDate = hireDate;
		this.department = department;
		this.office = office;
		this.job = job;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(BigDecimal hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, employeeId, firstName, hireDate, hourlyPay, job, lastName, office);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && employeeId == other.employeeId
				&& Objects.equals(firstName, other.firstName) && Objects.equals(hireDate, other.hireDate)
				&& Objects.equals(hourlyPay, other.hourlyPay) && Objects.equals(job, other.job)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(office, other.office);
	}
	
}
