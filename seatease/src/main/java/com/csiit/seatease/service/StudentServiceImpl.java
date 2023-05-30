package com.csiit.seatease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Student;
import com.csiit.seatease.repository.ExamRepository;
import com.csiit.seatease.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Exam saveExam(Exam exam) {
		return examRepository.save(exam);
	}

	@Override
	public Student saveStudent(long examId,Student student) {
		
		Exam exam =examRepository.findById(examId).get();
		student.setExam(exam);
		return studentRepository.save(student);
	}

	@Override
	public List<Exam> listExam() {
		return examRepository.findAll();
	}

	@Override
	public List<Student> getStudentByExamId(long examId) {
		
		return studentRepository.findByExamExamId(examId);
	}

}
