package com.sasi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sasi.entity.Department;
import com.sasi.entity.Staff;
import com.sasi.service.DepartmentService;
import com.sasi.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	StaffService service;
	@Autowired
	DepartmentService deptService;
	
	@GetMapping("/staffupload/{id}")
	public String staffUploadPage(@PathVariable int id,Model model) {
		
		Staff staff = new Staff();
		Department dept=deptService.getById(id);
		System.out.println(dept.getDeptName());
		model.addAttribute("dept", dept);
		model.addAttribute("staff", staff);
		
		return "staff_register"; 
	}
	
	@PostMapping("/addstaff")
	public String staffUpload(@Valid @ModelAttribute("staff") Staff staff,BindingResult binding,Model model) {
		if(binding.hasErrors()) {
			  return"redirect:/viewdept";
		  }
		  if(staff.getPassword().equals(staff.getrPassword())) {
				try {
				service.save(staff);
				return "redirect:/viewstaff";
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					model.addAttribute("errormsg", "Username,Addhar number, Mobile number and mail id must be unique!!");
					return "redirect:/viewdept";
				}
				}
			else {
				model.addAttribute("passerror","Your password and Re-type password is not match!!! Please check");
			}
		return "redirect:/viewdept";
	}
	
	@RequestMapping("/viewstaff")
	public String allStaff(Model model) {
		List<Staff> staff=service.listStaff();
		model.addAttribute("staff", staff);
		return "view_staff";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "login";
	}
}
