package com.csiit.seatease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csiit.seatease.dto.AuthenticationRequest;
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin authenticateAdmin(AuthenticationRequest admin) {
		Admin dbAdmin = adminRepository.findByUsername(admin.getUsername());
		if (dbAdmin != null && dbAdmin.getPassword().equals(admin.getPassword())) {
			return dbAdmin;
		}
		return null;
		
	}
}
