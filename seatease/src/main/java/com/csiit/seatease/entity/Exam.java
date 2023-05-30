package com.csiit.seatease.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Exam")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="examId")
	private long examId;
	
	@Column(name="examCode")
	private String examCode;
	
	@Column(name="examName")
	private String examName;
	
	@Column(name="examFees")
	private Double examFees;
	
	@Column(name="examDate")
	private Date examDate;
	
	
	 @OneToMany( cascade=CascadeType.ALL) 
	 private List<Student> student;
	 
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public Exam(String examCode, String examName, Double examFees, Date examDate) {
		super();
		this.examCode = examCode;
		this.examName = examName;
		this.examFees = examFees;
		this.examDate = examDate;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public String getExamCode() {
		return examCode;
	}

	public void setExamCode(String examCode) {
		this.examCode = examCode;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public Double getExamFees() {
		return examFees;
	}

	public void setExamFees(Double examFees) {
		this.examFees = examFees;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	
	  public List<Student> getStudent() { 
		  System.out.println("Called................");
		  return student; 
		  }
	 
	  public void setStudent(List<Student> student) { 
		  this.student = student; 
		  }
	 

	
	

}
