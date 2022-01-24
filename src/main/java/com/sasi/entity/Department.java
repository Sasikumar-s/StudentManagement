package com.sasi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Department {
	@Id
	private int deptId;
	@NotBlank
	private String deptName;
	@NotBlank
	private String hodName;
	@OneToMany(mappedBy="department")
	private List<Student> student;
	
	@OneToMany(mappedBy="department")
	private List<Staff> staff;
	
	
	
	public List<Staff> getStaff() {
		return staff;
	}
	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getHodName() {
		return hodName;
	}
	public void setHodName(String hodName) {
		this.hodName = hodName;
	}
	
	
}
