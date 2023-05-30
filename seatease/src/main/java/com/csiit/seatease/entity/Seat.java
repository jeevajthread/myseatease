package com.csiit.seatease.entity;

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
@Table(name="Seat")
@Transactional
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seatId")
	private long setId;
	@Column(name="seatName")
	private String seatName;
	@Column(name="seatDescription")
	private String seatDescription;
	
	@ManyToOne
    @JoinColumn(name = "roomId")
	private Room room;
		
	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Seat(String seatName, String seatDescription) {
		super();
		this.seatName = seatName;
		this.seatDescription = seatDescription;
	}

	public long getSetId() {
		return setId;
	}

	public void setSetId(long setId) {
		this.setId = setId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getSeatDescription() {
		return seatDescription;
	}

	public void setSeatDescription(String seatDescription) {
		this.seatDescription = seatDescription;
	}

	public Seat(long setId, String seatName, String seatDescription) {
		super();
		this.setId = setId;
		this.seatName = seatName;
		this.seatDescription = seatDescription;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	
	
   
}
