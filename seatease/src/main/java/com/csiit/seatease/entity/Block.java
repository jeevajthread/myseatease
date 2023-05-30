package com.csiit.seatease.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@Entity
@Table(name="Block")
@Transactional
public class Block  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blockId")
	private long blockId;
	@Column(name="blockName")
	private String blockName;
	@Column(name="blockDescription")
	private String blockDescription;
	
	@OneToMany( cascade=CascadeType.ALL)
	private List<Floor> floor;
	
	public Block() {
		// TODO Auto-generated constructor stub
	}
	public Block(String blockName, String blockDescription) {
		super();
		this.blockName = blockName;
		this.blockDescription = blockDescription;
	}
	
	
	public long getBlockId() {
		return blockId;
	}
	public void setBlockId(long blockId) {
		this.blockId = blockId;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getBlockDescription() {
		return blockDescription;
	}
	public void setBlockDescription(String blockDescription) {
		this.blockDescription = blockDescription;
	}
	public List<Floor> getFloor() {
		return floor;
	}
	public void setFloor(List<Floor> floor) {
		this.floor = floor;
	}
	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", blockName=" + blockName + ", blockDescription=" + blockDescription
				+ ", floor=" + floor + "]";
	}
	
	

}
