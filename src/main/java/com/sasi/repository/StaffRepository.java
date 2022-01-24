package com.sasi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sasi.entity.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, String> {
	Staff findByUserName(String username);
	
	
	@Query(value="select first_name from staff",nativeQuery=true)
	List<Staff> staffName();
}
