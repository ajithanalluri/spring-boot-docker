package com.example.mongodbdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "person")
public class Person {
	
	@Id
	private String id;
	
	private String firstname;
	private String lastname;
	private String address;
	private double phno;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPhno() {
		return phno;
	}
	public void setPhno(double phno) {
		this.phno = phno;
	}
	/*
	 * public Person(int id, String firstname, String lastname, String address,
	 * double phno) { super(); this.id = id; this.firstname = firstname;
	 * this.lastname = lastname; this.address = address; this.phno = phno; } public
	 * Person() { super(); }
	 */
	
	
	

}
