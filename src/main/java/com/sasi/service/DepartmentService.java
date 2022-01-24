package com.sasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasi.entity.Department;
import com.sasi.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository deptRepo;
	public void save(Department dept) {
		deptRepo.save(dept);
	}
	public Department getById(int id){
		return deptRepo.getById(id);
	}
	public List<Department> getAllDept(){
		return deptRepo.findAll();
	}
}
