package com.sasi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Staff {
	@Id
	@NotBlank
	private String StaffId;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	
	private long mobileNumber;
	@Email(message="Enter Valid Email ID")
	private String email;
	@NotBlank
	private String experience;

	@ManyToOne(targetEntity=Department.class)
	@JoinColumn(name="deptId")
	private Department department;
	
	@NotNull
	@Column(unique=true)
	private String userName;
	@NotBlank
	private String password;
	@NotBlank
	private String rPassword;
	private String role;
	
	
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getrPassword() {
		return rPassword;
	}
	public void setrPassword(String rPassword) {
		this.rPassword = rPassword;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	
	
	
	
}
