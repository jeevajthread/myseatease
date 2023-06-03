package com.csiit.seatease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.csiit.seatease.entity.Admin;
import com.csiit.seatease.entity.Exam;
import com.csiit.seatease.entity.Student;
import com.csiit.seatease.service.StudentService;

@RestController
@CrossOrigin(origins="*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/saveExam")
	public Exam saveExam(@RequestBody Exam exam) {
		return studentService.saveExam(exam);
	}
	@PostMapping("/saveStudent/{examId}")
	public Student saveStudent( @PathVariable("examId") long examId,@RequestBody Student student) {
		return studentService.saveStudent( examId, student);
	}
	@GetMapping("/listExam")
	public List<Exam> listExam() {
		return studentService.listExam();
	}
	@GetMapping("listStudents/{examId}")
	public List<Student> getStudentByExamId(@PathVariable("examId") long examId) {
		return studentService.getStudentByExamId(examId);
	}
	@GetMapping("/getExamById/{examId}")
	public Exam getExamById(@PathVariable("examId") long examId) {
		return studentService.getExamById(examId);
	}
	@PutMapping("/updateExam/{examId}")
	public Exam updateExam(@PathVariable("examId") long examId, @RequestBody Exam exam) {
		return studentService.updateExam(examId, exam);
	}
	@GetMapping("/getStudentById/{studentId}")
	public Student getStudentById(@PathVariable("studentId") long studentId) {
		return studentService.getStudentById(studentId);
	}
	@PutMapping("/updateStudent/{studentId}")
	public Student updateStudent(@PathVariable("studentId") long studentId, @RequestBody Student student) {
		return studentService.updateStudent(studentId, student);
	}
	@DeleteMapping("/deleteExam/{examId}")
	public void deleteExam(@PathVariable("examId") long examId) {
		System.out.println("deleteExam......");
		studentService.deleteExam(examId);
	}
	@DeleteMapping("/deleteStudent/{studentId}")
	public void deleteStudent(@PathVariable("studentId") long studentId) {
		studentService.deleteStudent(studentId);
	}
	@PostMapping("/authenticateStudent")
	public Student authenticateStudent( @RequestBody AuthenticationRequest student) {
		Student dbStudent = studentService.authenticateStudent(student);
		System.out.println(dbStudent.getStudentId()+"..........");
		return dbStudent;
	}
	
}
