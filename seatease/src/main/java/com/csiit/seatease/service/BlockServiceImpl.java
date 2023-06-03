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

	@Override
	public List<Seat> listSeats(long blockId,long floorId,long roomId){
		return seatRepository.findByRoomFloorBlockBlockIdAndRoomFloorFloorIdAndRoomRoomId(blockId, floorId, roomId);
	}

	@Override
	public Block updateBlock(long blockId, Block block) {
		Block dbBlock=blockRepository.findById(blockId).get();
		dbBlock.setBlockName(block.getBlockName());
		dbBlock.setBlockDescription(block.getBlockDescription());
		
		return blockRepository.save(dbBlock);
	}

	@Override
	public Floor updateFloor( long floorId, Floor floor) {
		Floor dbFloor=floorRepository.findById(floorId).get();
		dbFloor.setFloorName(floor.getFloorName());
		dbFloor.setFloorDescription(floor.getFloorDescription());
		return floorRepository.save(dbFloor);
	}

	@Override
	public Block getBlockById(long blockId) {
		
		return blockRepository.findById(blockId).get();
	}

	@Override
	public Floor getFloorById(long floorId) {
		return floorRepository.findById(floorId).get();
		
	}

	@Override
	public Room getRoomById(long roomId) {
		return roomRepository.findById(roomId).get();
	}

	@Override
	public Room updateRoom(long roomId, Room room) {
		Room dbRoom=roomRepository.findById(roomId).get();
		dbRoom.setRoomName(room.getRoomName());
		dbRoom.setRoomDescription(room.getRoomDescription());
		return roomRepository.save(dbRoom);
	}

	@Override
	public Seat getSeatById(long seatId) {
		return seatRepository.findById(seatId).get();
	}

	@Override
	public Seat updateSeat(long seatId, Seat seat) {
		Seat dbSeat=seatRepository.findById(seatId).get();
		dbSeat.setSeatName(seat.getSeatName());
		dbSeat.setSeatDescription(seat.getSeatDescription());
		return seatRepository.save(dbSeat);
	}

	@Override
	public void deleteBlock(long blockId) {
		blockRepository.deleteById(blockId);
		
	}

	@Override
	public void deleteFloor(long floorId) {
		floorRepository.deleteById(floorId);		
	}

	@Override
	public void deleteRoom(long roomId) {
		roomRepository.deleteById(roomId);
	}

	@Override
	public void deleteSeat(long seatId) {
		seatRepository.deleteById(seatId);
	}
	
	
}
