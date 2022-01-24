package com.sasi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sasi.entity.Study;
import com.sasi.repository.StudyRepository;

@Service
public class StudyService {
	@Autowired
	StudyRepository studyRepo;
	
	public void save(Study study) {
		studyRepo.save(study);
	}
}
