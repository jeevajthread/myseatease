package com.csiit.seatease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csiit.seatease.dto.AuthenticationRequest;
import com.csiit.seatease.dto.AuthenticationResponse;
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Seat;
import com.csiit.seatease.entity.Student;
import com.csiit.seatease.service.JwtService;
import com.csiit.seatease.service.StudentService;
import com.csiit.seatease.service.StudentUserDetails;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/saveExam")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Exam saveExam(@RequestBody Exam exam) {
		return studentService.saveExam(exam);
	}

	@PostMapping("/saveStudent/{examId}")
	public Student saveStudent(@PathVariable("examId") long examId, @RequestBody Student student) {
		return studentService.saveStudent(examId, student);
	}

	@GetMapping("/listExam")
	public List<Exam> listExam() {
		return studentService.listExam();
	}

	@GetMapping("listStudents/{examId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Student> getStudentByExamId(@PathVariable("examId") long examId) {
		return studentService.getStudentByExamId(examId);
	}

	@GetMapping("/getExamById/{examId}")
	public Exam getExamById(@PathVariable("examId") long examId) {
		return studentService.getExamById(examId);
	}

	@PutMapping("/updateExam/{examId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Exam updateExam(@PathVariable("examId") long examId, @RequestBody Exam exam) {
		return studentService.updateExam(examId, exam);
	}

	@GetMapping("/getStudentById/{studentId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Student getStudentById(@PathVariable("studentId") long studentId) {
		System.out.println("STUDENT : STUDENT");
		Student s = studentService.getStudentById(studentId);
		System.out.println("STUDENT : " + s);

		return s;

	}

	@PutMapping("/updateStudent/{studentId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Student updateStudent(@PathVariable("studentId") long studentId, @RequestBody Student student) {
		return studentService.updateStudent(studentId, student);
	}

	@DeleteMapping("/deleteExam/{examId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteExam(@PathVariable("examId") long examId) {
		System.out.println("deleteExam......");
		studentService.deleteExam(examId);
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public void deleteStudent(@PathVariable("studentId") long studentId) {
		studentService.deleteStudent(studentId);
	}

	/*
	 * @PostMapping("/authenticateStudent") public Student
	 * authenticateStudent( @RequestBody AuthenticationRequest student) { Student
	 * dbStudent = studentService.authenticateStudent(student);
	 * System.out.println(dbStudent.getStudentId()+".........."); return dbStudent;
	 * }
	 */
	@GetMapping("/generateSeat/{examId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Seat generateSeat(@PathVariable("examId") long examId) {
		System.out.println(" generateSeat........");
		return studentService.generateSeat(examId);
	}

	@PostMapping("/authenticate")
	public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
		System.out.println("authenticate......");
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			StudentUserDetails stUD = (StudentUserDetails) authentication.getPrincipal();
			Student student = stUD.getStudent();
			String token = jwtService.generateToken(authenticationRequest.getUsername());
			System.out.println(student);
			System.out.println(token);
			AuthenticationResponse authenticationResponse = new AuthenticationResponse(token, student);
			return authenticationResponse;
			// return jwtService.generateToken(authenticationRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}

}
