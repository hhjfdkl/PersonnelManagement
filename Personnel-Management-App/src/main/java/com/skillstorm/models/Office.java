package com.skillstorm.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "officeId")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "office_id")
	private int officeId;
	
	@Column(name = "office_name")
	private String officeName;
	
	@Column(name = "street_address")
	private String address;
	
	@Column(name = "address_suite")
	private String suite;
	
	@Column(name = "location_city")
	private String city;
	
	@Column(name = "location_state")
	private String state;
	
	@Column(name = "zip_code")
	private int zip;
	
	@Column(name = "max_capacity")
	private int maxCapacity;
	
	
	//same as in department
	@OneToMany(mappedBy = "office", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("office")
	private List<Employee> employees;
	
	

	
	public Office()
	{
		super();
	}
	
	public Office(int officeId, String officeName, String address, String suite, String city, 
			String state, int zip, int maxCapacity, List<Employee> employees) //
	{
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.address = address;
		this.suite = suite;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.maxCapacity = maxCapacity;
		this.employees = employees;
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

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
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


	
	
	@Override
	public String toString() {
		return "Job [officeId=" + officeId + ", officeName=" + officeName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, city, zip, maxCapacity, officeId, officeName, state,
				suite, employees); //
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
				&& Objects.equals(zip, other.zip) 
				&& Objects.equals(employees, other.employees) && maxCapacity == other.maxCapacity
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName)
				&& Objects.equals(state, other.state) && Objects.equals(suite, other.suite);
	}
	
	
	
	
}
