package com.csiit.seatease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
  Admin	findByUsername(String username);
}
