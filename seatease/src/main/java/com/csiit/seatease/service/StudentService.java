package com.csiit.seatease.service;

import java.util.List;

import com.csiit.seatease.dto.AuthenticationRequest;
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Seat;
import com.csiit.seatease.entity.Student;

public interface StudentService {
	public Exam saveExam(Exam exam);
	public Student saveStudent(long examId, Student student );
	public List<Exam> listExam();
	public List<Student> getStudentByExamId(long examId);

	public Exam getExamById(long examId);
    public Exam updateExam(long examId,Exam exam);
    public Student getStudentById(long studentId);
    public Student updateStudent(long studentId,Student student);
    public Seat generateSeat(long examId);
    
    public void deleteExam(long examId);
    public void deleteStudent(long studentId);
//    public Student authenticateStudent(AuthenticationRequest admin) ;
  
}
