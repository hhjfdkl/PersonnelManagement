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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "offices")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "office_id")
	private int officeId;
	
	@Column(name = "office_name")
	private String officeName;
	
	@Column(name = "office_street_address")
	private String address;
	
	@Column(name = "office_address_suite")
	private String suite;
	
	@Column(name = "office_location_city")
	private String city;
	
	@Column(name = "office_location_province")
	private String state;
	
	@Column(name = "office_location_country")
	private String country;
	
	@Column(name = "max_capacity")
	private int maxCapacity;
	
	
	//same as in department
	@OneToMany(mappedBy = "office", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("office")
	private List<Employee> employees;
	
	//mapping many to many for office_department
	@ManyToMany
	@JoinTable(
			  name = "offices_departments"
			, joinColumns = @JoinColumn(name = "office_id")
			, inverseJoinColumns = @JoinColumn(name = "department_id")
	)
	@JsonIgnoreProperties("offices")
	private List<Department> departments;

	
	public Office()
	{
		super();
	}
	
	public Office(int officeId, String officeName, String address, String suite, String city, 
			String state, String country, int maxCapacity, List<Employee> employees, List<Department> departments)
	{
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.address = address;
		this.suite = suite;
		this.city = city;
		this.state = state;
		this.country = country;
		this.maxCapacity = maxCapacity;
		this.employees = employees;
		this.departments = departments;
	}
	
	
	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSuite() {
		return suite;
	}

	public void setSuite(String suite) {
		this.suite = suite;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	
	
	@Override
	public String toString() {
		return "Job [officeId=" + officeId + ", officeName=" + officeName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, city, country, departments, employees, maxCapacity, officeId, officeName, state,
				suite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Office other = (Office) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(departments, other.departments)
				&& Objects.equals(employees, other.employees) && maxCapacity == other.maxCapacity
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName)
				&& Objects.equals(state, other.state) && Objects.equals(suite, other.suite);
	}
	
	
	
	
}
