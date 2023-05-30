package com.csiit.seatease.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csiit.seatease.entity.Block;
import com.csiit.seatease.entity.Floor;
import com.csiit.seatease.entity.Room;
import com.csiit.seatease.entity.Seat;
import com.csiit.seatease.repository.BlockRepository;
import com.csiit.seatease.repository.FloorRepository;
import com.csiit.seatease.repository.RoomRepository;
import com.csiit.seatease.repository.SeatRepository;

@Service
public class BlockServiceImpl implements BlockService{
	
	@Autowired
	private BlockRepository blockRepository;
	
	@Autowired
	private FloorRepository floorRepository;
	
	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private SeatRepository seatRepository;
	@Override
	public Block addBlock(Block block) {
		
		return blockRepository.save(block);
	}

	@Override
	public List<Block> listBlocks() {
		
		return blockRepository.findAll();
	}

	@Override
	public Floor saveFloor(long blockId,Floor floor) {
		Block block=blockRepository.findById(blockId).get();
		floor.setBlock(block);
		return floorRepository.save(floor);
	}

	@Override
	public List<Floor> listFloor() {
		
		return floorRepository.findAll();
	}
	@Override
	public List<Floor> getFloorsByBlockId(Long blockId) {
        return floorRepository.findByBlockBlockId(blockId);
    }
	@Override
	public List<Room> getRoomsByFloorId(long blockId,long floorId) {
        return roomRepository.findByFloorBlockBlockIdAndFloorFloorId( blockId, floorId);
    }
	@Override
	public Room saveRoom(long blockId,long floorId,Room room) {
		Block block=blockRepository.findById(blockId).get();
		Floor floor=floorRepository.findById(floorId).get();
		floor.setBlock(block);
		room.setFloor(floor);
		return roomRepository.save(room);
	}

	@Override
	public Seat saveSeat(long blockId, long floorId, long roomId, Seat seat) {
		Block block=blockRepository.findById(blockId).get();
		Floor floor=floorRepository.findById(floorId).get();
		Room room=roomRepository.findById(roomId).get();
		floor.setBlock(block);
		room.setFloor(floor);
		seat.setRoom(room);
		return seatRepository.save(seat);
	}
	
	
}
