package com.sasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasi.entity.Student;
import com.sasi.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;
	
	public void save(Student student) {
		repo.save(student);
	}
	public List<Student> listAll(){
		return repo.findAll();
	}
}
