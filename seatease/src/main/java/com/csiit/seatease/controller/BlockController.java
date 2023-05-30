package com.csiit.seatease.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csiit.seatease.entity.Block;
import com.csiit.seatease.entity.Floor;
import com.csiit.seatease.entity.Room;
import com.csiit.seatease.entity.Seat;
import com.csiit.seatease.service.BlockService;

@RestController
@CrossOrigin(origins="*")
public class BlockController {

	@Autowired
	private BlockService blockService;
	
	@PostMapping("/addBlock")
	public Block addBlock( @RequestBody Block block) {
		
		return blockService.addBlock(block);
	}
	@GetMapping("/list")
	public List<Block> listBlocks() {
		System.out.println("Called list Blocks.........");
		List <Block> blockList= blockService.listBlocks();
		blockList.forEach(a->System.out.println(a));
		 return blockList;
	}
	
	@PostMapping("/saveFloor/{blockId}")
	public String saveFloor(@PathVariable("blockId") long blockId,@RequestBody Floor floor) {
		System.out.println("Called saveFloor...");
		 blockService.saveFloor(blockId, floor);
		 return "Saved Successfully";
	}
	
	@GetMapping("/listFloor")
	public List<Floor> listFloor() {
		return blockService.listFloor();
		
	}
	
	@GetMapping("/getFloors/{blockId}")
    public List<Floor> getFloorsByBlockId(@PathVariable Long blockId) {
		System.out.println("Called......getFloors");
        return blockService.getFloorsByBlockId(blockId);
    }
	@GetMapping("/getRooms/{blockId}/{floorId}")
	public List<Room> getRoomsByFloorId(@PathVariable("blockId") long blockId,@PathVariable("floorId") long floorId) {
		System.out.println("Called ..getRooms");
		return blockService.getRoomsByFloorId(blockId,floorId);
	}
	@PostMapping("/saveRoom/{blockId}/{floorId}")
	public Room saveRoom(@PathVariable("blockId") long blockId ,@PathVariable("floorId") long floorId,@RequestBody Room room) {
	System.out.println("SaveRoom...............");
		return blockService.saveRoom(blockId,floorId, room);
	}
	@PostMapping("/saveSeat/{blockId}/{floorId}/{roomId}")
	public Seat saveSeat(@PathVariable("blockId") long blockId,@PathVariable("floorId") long floorId,@PathVariable("roomId") long roomId,@RequestBody Seat seat) {
		
		return blockService.saveSeat(blockId, floorId, roomId, seat);
	}
	}

