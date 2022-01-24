package com.sasi.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sasi.entity.Staff;

public class ProfileDetails implements UserDetails {
	
	Staff staff;
	
	
	public ProfileDetails(Staff staff) {
		super();
		this.staff = staff;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(staff.getRole()));
	}

	@Override
	public String getPassword() {
		return staff.getPassword();
	}

	@Override
	public String getUsername() {
		return staff.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
