package com.csiit.seatease.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name = "Floor")
@Transactional
public class Floor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "floorId")
	private long floorId;
	@Column(name = "floorName")
	private String floorName;
	@Column(name = "floorDescription")
	private String floorDescription;
	
	@OneToMany( cascade=CascadeType.ALL)
	private List<Room> room;
	
	@ManyToOne
    @JoinColumn(name = "blockId")
	private Block block;
	
	public Floor() {
		// TODO Auto-generated constructor stub
	}

	public Floor(String floorName, String floorDescription) {
		super();
		this.floorName = floorName;
		this.floorDescription = floorDescription;
	}

	

	public long getFloorId() {
		return floorId;
	}

	public void setFloorId(long floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getFloorDescription() {
		return floorDescription;
	}

	
	public void setFloorDescription(String floorDescription) {
		this.floorDescription = floorDescription;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	
	


}
