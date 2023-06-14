package com.csiit.seatease.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.entity.Student;
import com.csiit.seatease.repository.AdminRepository;
import com.csiit.seatease.repository.StudentRepository;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Admin> admin = adminRepository.findByUserName(username);
		System.out.println("Admin : " + admin + " : " + username);
		if (admin.isPresent()) {
			UserDetails userDetails = admin.map(AdminUserDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("Admin Not Found " + username));
			System.out.println(userDetails.getAuthorities());
			return userDetails;
		}

		Optional<Student> student = studentRepository.findByUserName(username);
		System.out.println("Student : " + student + " : " + username);

		if (student.isPresent()) {
			UserDetails userDetails = student.map(StudentUserDetails::new)
					.orElseThrow(() -> new UsernameNotFoundException("Student Not Found " + username));
			System.out.println(userDetails);
			return userDetails;
		}
		throw new UsernameNotFoundException("User not found with username: " + username);
	}

}
