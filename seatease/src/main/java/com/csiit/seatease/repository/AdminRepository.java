package com.csiit.seatease.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Optional<Admin> findByUserName(String username);
}
