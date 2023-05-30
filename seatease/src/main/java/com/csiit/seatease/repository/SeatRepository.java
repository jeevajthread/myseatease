package com.csiit.seatease.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{

}
