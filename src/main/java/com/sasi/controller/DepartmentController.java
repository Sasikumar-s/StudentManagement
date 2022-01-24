package com.sasi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sasi.entity.Department;
import com.sasi.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService service;
	
	@GetMapping("newdept")
	public String addDept(Model model) {
		Department dept = new Department();
		model.addAttribute("dept", dept);
		return "department_form";		
	}
	
	@PostMapping("adddepart")
	public String newDepart(@Valid @ModelAttribute("dept") Department dept,BindingResult binding,Model model) {
		if(binding.hasErrors()) {
			  return"department_form";
		  }
		else {
		service.save(dept);
		return "redirect:/viewdept";
		}
	}
	@RequestMapping("/viewdept")
	public String allDept(Model model) {
		List<Department> dept=service.getAllDept();
		model.addAttribute("list", dept);
		return "view_dept";
	}
}
