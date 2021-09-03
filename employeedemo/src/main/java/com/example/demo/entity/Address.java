package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = " Employee Address ID")
	private int id;
	
	@ApiModelProperty(notes = " Employee Address Street")
	@Size(min = 2)
	private String street;
	
	@ApiModelProperty(notes = " Employee Address Type")
	private String type;
	
	@ApiModelProperty(notes = " Employee Address City")
	@Column(name = "city", nullable = false)
	private String city;
	
	@ApiModelProperty(notes = " Employee Address ZipCode")
	@Column(name = "zipcode", nullable = false, length = 6)
	private int zipcode;
	
	@ManyToOne
	@JsonBackReference
    private Employee employee;
	
	public Address()
	{
		
	}
	public Address(int id, String street, String type, String city, int zipcode, Employee employee) {
		super();
		this.id = id;
		this.street = street;
		this.type = type;
		this.city = city;
		this.zipcode = zipcode;
		this.employee = employee;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


}

