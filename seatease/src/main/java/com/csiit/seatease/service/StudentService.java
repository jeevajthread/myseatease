package com.csiit.seatease.service;

import java.util.List;

import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Student;

public interface StudentService {
	public Exam saveExam(Exam exam);
	public Student saveStudent(long examId, Student student );
	public List<Exam> listExam();
	public List<Student> getStudentByExamId(long examId);

}
