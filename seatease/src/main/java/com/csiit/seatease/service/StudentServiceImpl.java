package com.csiit.seatease.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csiit.seatease.dto.AuthenticationRequest;
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Seat;
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

	@Override
	public Exam getExamById(long examId) {
		 return examRepository.findById(examId).get();
	}

	@Override
	public Exam updateExam(long examId, Exam exam) {
		Exam dbExam=examRepository.findById(examId).get();
		dbExam.setExamCode(exam.getExamCode());
		dbExam.setExamName(exam.getExamName());
		dbExam.setExamDate(exam.getExamDate());
		dbExam.setExamFees(exam.getExamFees());
		return examRepository.save(dbExam);
	}

	@Override
	public Student getStudentById(long studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public Student updateStudent(long studentId, Student student) {
		Student dbStudent=studentRepository.findById(studentId).get();
		dbStudent.setName(student.getName());
		dbStudent.setAge(student.getAge());
		dbStudent.setEmail(student.getEmail());
		dbStudent.setPhoneNo(student.getPhoneNo());
		dbStudent.setSemester(student.getSemester());
		dbStudent.setActive(student.isActive());
		return studentRepository.save(dbStudent);
	}

	@Override
	public void deleteExam(long examId) {
		examRepository.deleteById(examId);
	}

	@Override
	public void deleteStudent(long studentId) {
	studentRepository.deleteById(studentId);
	}

	@Override
	public Student authenticateStudent(AuthenticationRequest student) {
		Student dbStudent= studentRepository.findByUserName(student.getUsername());
		if (dbStudent != null && dbStudent.getPassword().equals(student.getPassword())) {
			return dbStudent;
		}
		return null;
		
	}

	
}
