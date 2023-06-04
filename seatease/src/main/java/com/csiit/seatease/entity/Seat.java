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
@Table(name="Seat")
@Transactional
public class Seat {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="seatId")
	private long seatId;
	@Column(name="seatName")
	private String seatName;
	@Column(name="seatDescription")
	private String seatDescription;
	
	@ManyToOne
    @JoinColumn(name = "roomId")
	private Room room;
	
	 @OneToMany( cascade=CascadeType.ALL) 
	 private List<Student> student;

		
	public Seat() {
		// TODO Auto-generated constructor stub
	}

	public Seat(String seatName, String seatDescription) {
		super();
		this.seatName = seatName;
		this.seatDescription = seatDescription;
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
	

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public long getSeatId() {
		return seatId;
	}

	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}

	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatName=" + seatName + ", seatDescription=" + seatDescription + ", room="
				+ room + "]";
	}

	
	 
}
