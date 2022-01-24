package com.sasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sasi.entity.Department;
import com.sasi.entity.Staff;
import com.sasi.entity.Study;
import com.sasi.service.DepartmentService;
import com.sasi.service.StaffService;
import com.sasi.service.StudyService;

@Controller
public class StudyController {
	@Autowired
	StudyService service;
	@Autowired
	StaffService staffService;
	@Autowired
	DepartmentService deptService;
	@GetMapping("/studyupload/{id}")
	public String studyForm(@PathVariable("id") int id,Model model) {
		Study study = new Study();
		List<Staff> staff = staffService.listStaff();

		Department dept = deptService.getById(id);
		model.addAttribute("staff", staff);
		model.addAttribute("dept",dept);
		model.addAttribute("study", study);
		return "study_upload";
	}
}
