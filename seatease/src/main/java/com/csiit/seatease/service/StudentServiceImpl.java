package com.csiit.seatease.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csiit.seatease.dto.AuthenticationRequest;
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Seat;
import com.csiit.seatease.entity.Student;
import com.csiit.seatease.repository.ExamRepository;
import com.csiit.seatease.repository.SeatRepository;
import com.csiit.seatease.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Exam saveExam(Exam exam) {
		return examRepository.save(exam);
	}

	@Override
	public Student saveStudent(long examId, Student student) {
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		Exam exam = examRepository.findById(examId).get();
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
		Exam dbExam = examRepository.findById(examId).get();
		dbExam.setExamCode(exam.getExamCode());
		dbExam.setExamName(exam.getExamName());
		dbExam.setExamDate(exam.getExamDate());
		dbExam.setExamFees(exam.getExamFees());
		return examRepository.save(dbExam);
	}

	@Override
	public Student getStudentById(long studentId) {
		System.out.println("studentId: "+studentId);
		Student s = studentRepository.findById(studentId).get();
		System.out.println("Here... "+s);
		return s;
//		return studentRepository.findById(studentId).get();
	}

	@Override
	public Student updateStudent(long studentId, Student student) {
		Student dbStudent = studentRepository.findById(studentId).get();
		dbStudent.setName(student.getName());
		dbStudent.setAge(student.getAge());
		dbStudent.setEmail(student.getEmail());
		dbStudent.setPhoneNo(student.getPhoneNo());
		dbStudent.setSemester(student.getSemester());
		dbStudent.setActive(student.isActive());
		dbStudent.setFeeReceiptNumber(student.getFeeReceiptNumber());
		dbStudent.setSeat(student.getSeat());
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

	/*
	 * @Override public Student authenticateStudent(AuthenticationRequest student) {
	 * Optional<Student> dbStudent =
	 * studentRepository.findByUserName(student.getUsername()); if (dbStudent !=
	 * null && dbStudent.getPassword().equals(student.getPassword())) { return
	 * dbStudent; } return null;
	 * 
	 * }
	 */
	@Override
	public Seat generateSeat(long examId) {
		List<Seat> seats = seatRepository.findAll();
		List<Student> students = studentRepository.findByExamExamId(examId);
		List<Long> seatIds = new ArrayList();
		List<Long> takenSeatIds = new ArrayList();

		for (Seat seat : seats) {
			seatIds.add(seat.getSeatId());
		}
		for (Student student : students) {
			if (student.getSeat() != null) {
				takenSeatIds.add(student.getSeat().getSeatId());
			}
		}
		seatIds.removeAll(takenSeatIds);

		Random random = new Random();
		long randomIndex = random.nextInt(seatIds.size());
		long randomlySelectedSeat = seatIds.get((int) randomIndex);
		Seat seat = seatRepository.findById(randomlySelectedSeat).get();
		System.out.println(seat.getSeatId());
		return seat;
	}

}
