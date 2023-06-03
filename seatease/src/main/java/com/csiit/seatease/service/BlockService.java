package com.csiit.seatease.service;

import java.util.List;

import com.csiit.seatease.entity.Block;
import com.csiit.seatease.entity.Floor;
import com.csiit.seatease.entity.Room;
import com.csiit.seatease.entity.Seat;

public interface BlockService {
	public Block addBlock(Block block);
	public Floor saveFloor(long blockId,Floor floor) ;
	public Room saveRoom(long blockId,long floorId,Room room);
	public Seat saveSeat(long blockId,long floorId,long roomId,Seat seat);
	
	public List<Block> listBlocks();
    public List<Floor> listFloor();
    public List<Floor> getFloorsByBlockId(Long blockId) ;
    public List<Room> getRoomsByFloorId(long blockId,long floorId) ;
    public List<Seat> listSeats(long blockId,long floorId,long roomId);
    
    public Block getBlockById(long blockId);
    public Block updateBlock(long blocId,Block block);
    public Floor getFloorById(long floorId);
    public Floor updateFloor(long floorId,Floor floor);
    public Room getRoomById(long roomId);
    public Room updateRoom(long roomId,Room room);
    public Seat getSeatById(long seatId);
    public Seat updateSeat(long seatId,Seat seat);
    
    public void deleteBlock(long blockId);
    public void deleteFloor(long floorId);
    public void deleteRoom(long roomId);
    public void deleteSeat(long seatId);

}