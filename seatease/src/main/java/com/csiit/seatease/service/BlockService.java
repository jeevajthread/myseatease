package com.csiit.seatease.service;

import java.util.List;

import com.csiit.seatease.entity.Block;
import com.csiit.seatease.entity.Floor;
import com.csiit.seatease.entity.Room;
import com.csiit.seatease.entity.Seat;

public interface BlockService {
	public Block addBlock(Block block);
	public List<Block> listBlocks();
	public Floor saveFloor(long blockId,Floor floor) ;
	
   public List<Floor> listFloor();
   public List<Floor> getFloorsByBlockId(Long blockId) ;
   public Room saveRoom(long blockId,long floorId,Room room);
   public List<Room> getRoomsByFloorId(long blockId,long floorId) ;
   public Seat saveSeat(long blockId,long floorId,long roomId,Seat seat);
}
