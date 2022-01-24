package com.sasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sasi.config.ProfileDetails;
import com.sasi.entity.Staff;
import com.sasi.repository.StaffRepository;

@Service
public class StaffService implements UserDetailsService{
	@Autowired
	StaffRepository staffRepo;

BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	
	public void save(Staff staff) {
		staff.setPassword(passwordEncoder.encode(staff.getPassword()));
		staff.setrPassword(passwordEncoder.encode(staff.getrPassword()));
		staffRepo.save(staff);
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Staff staff=staffRepo.findByUserName(username);
		if(staff==null) {
			throw new UsernameNotFoundException("user 403");
		}
		return new ProfileDetails(staff);
	}
	public List<Staff> listStaff(){
		return staffRepo.findAll();
	}
	public List<Staff> listStaffName(){
		return staffRepo.staffName();
	}
	
}
