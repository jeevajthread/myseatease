package com.csiit.seatease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csiit.seatease.dto.AuthenticationRequest;
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.service.AdminService;

@RestController
@CrossOrigin(origins="*")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/saveAdmin")
	public Admin saveAdmin(@RequestBody Admin admin) {
		System.out.println("Called...............");
		return adminService.saveAdmin(admin);
	}
	
	@PostMapping("/authenticateAdmin")
	public Admin authenticateAdmin( @RequestBody AuthenticationRequest admin) {
		Admin dbAdmin = adminService.authenticateAdmin(admin);
		return dbAdmin;
	}
}
