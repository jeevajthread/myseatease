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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="studentId")
	private long studentId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNo")
	private long phoneNo;
	
	@Column(name="semester")
	private String semester;
	
	@Column(name="userName",unique = true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private boolean active;

	@Column(name="feereceiptnumber")
	private String feeReceiptNumber;

	@ManyToOne
	@JoinColumn(name="seatId")
	private Seat seat;


	@ManyToOne
    @JoinColumn(name = "examId")
	private Exam exam;
	
	@Column(name="roles")
	private String roles;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, int age, String email, long phoneNo, String semester, String userName, String password,
			boolean active, Exam exam) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phoneNo = phoneNo;
		this.semester = semester;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.exam = exam;
	}

	public String getFeeReceiptNumber() {
		return feeReceiptNumber;
	}

	public void setFeeReceiptNumber(String feeReceiptNumber) {
		this.feeReceiptNumber = feeReceiptNumber;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}


	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isActive() {
		return active;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
		public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", email=" + email + ", phoneNo="
				+ phoneNo + ", semester=" + semester + ", userName=" + userName + ", password=" + password + ", active="
				+ active + ", feeReceiptNumber=" + feeReceiptNumber + ", seat=" + seat + ", exam=" + exam + ", roles="
				+ roles + "]";
	}

	

}
