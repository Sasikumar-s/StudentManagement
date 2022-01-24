package com.sasi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
	@Id
	private long regNo;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	private long mobileNumber;
	@Email(message="Enter valid Email Address")
	private String email;
	@NotBlank
	
	@ManyToOne(targetEntity=Study.class)
	@JoinColumn(name="year")
	private Study study;
	
	@ManyToOne(targetEntity=Department.class)
	@JoinColumn(name="deptId")
	private Department department;
	private double fees;
	
	
	
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	
	
	
	

}
