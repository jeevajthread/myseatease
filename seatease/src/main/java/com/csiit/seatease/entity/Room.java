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
@Table(name="Room")
@Transactional
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roomId")
	private long roomId;
	@Column(name="roomName")
	private String roomName;
	@Column(name="roomDescription")
	private String roomDescription;
	
	@OneToMany(  cascade=CascadeType.ALL)
	private List<Seat> room;
	
	@ManyToOne
    @JoinColumn(name = "floorId")
	private Floor floor;
	
	
	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(String roomName, String roomDescription) {
		super();
		this.roomName = roomName;
		this.roomDescription = roomDescription;
	}

		public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	

	public List<Seat> getRoom() {
		return room;
	}

	public void setRoom(List<Seat> room) {
		this.room = room;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	
	
		
	
	
}
