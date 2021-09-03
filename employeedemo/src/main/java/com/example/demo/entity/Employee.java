package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// try GenerationType.SEQUENCE
	@ApiModelProperty(notes = " Employee ID")
	@Column(name = "ID")
	private int employeeId;
	
	@Column(name = "EmployeeName", nullable = false )
	@ApiModelProperty(notes = " Employee Name")
	@Size(min = 2)
	private String name;
	
	@Column(name = "EmployeeSalary")
	@ApiModelProperty(notes = " Employee Salary")
	private double salary;
	
	@Column(name = "EmployeePhno", length = 10)
	@ApiModelProperty(notes = " Employee Phone Number")
	private long phno;
	
	@ApiModelProperty(notes = " Employee Address")
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name="EMPLOYEE_ID")
	@JsonManagedReference
	private Set<Address> address;

	public Employee()
	{
		
	}
	
	public Employee(int employeeId, String name, double salary, long phno, Set<Address> address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.phno = phno;
		this.address = address;
	}

	public int getId() {
		return employeeId;
	}

	public void setId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	

}
