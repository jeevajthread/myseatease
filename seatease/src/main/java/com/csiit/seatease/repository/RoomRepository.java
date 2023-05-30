package com.csiit.seatease.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csiit.seatease.entity.Floor;
import com.csiit.seatease.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	//List<Floor> findByFloorFloorId(long floorId);
	List<Room> findByFloorBlockBlockIdAndFloorFloorId(Long blockId, Long floorId);
}
