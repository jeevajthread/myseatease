package com.csiit.seatease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	
	@Autowired
	PasswordEncoder passwordEncoder;


	public String addNewAdmin(Admin admin) {
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminRepository.save(admin);
		return "User added successfully";
	}

	/*
	 * @Override public Admin saveAdmin(Admin admin) { return
	 * adminRepository.save(admin); }
	 */
	/*
	 * @Override public Admin authenticateAdmin(AuthenticationRequest admin) { Admin
	 * dbAdmin = adminRepository.findByUsername(admin.getUsername()); if (dbAdmin !=
	 * null && dbAdmin.getPassword().equals(admin.getPassword())) { return dbAdmin;
	 * } return null;
	 * 
	 * }
	 */}
