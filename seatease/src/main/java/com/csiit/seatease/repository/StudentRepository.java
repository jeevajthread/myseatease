package com.csiit.seatease.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student> findByExamExamId(long examId);
	Optional<Student> findByUserName(String username);


}
