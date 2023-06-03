package com.csiit.seatease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	List<Seat> findByRoomFloorBlockBlockIdAndRoomFloorFloorIdAndRoomRoomId(long blockId,long floorId,long roomId);
}
