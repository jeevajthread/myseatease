package com.csiit.seatease.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Floor;



public interface FloorRepository extends JpaRepository<Floor, Long> {
	
	 List<Floor> findByBlockBlockId(Long blockId);
   
}
