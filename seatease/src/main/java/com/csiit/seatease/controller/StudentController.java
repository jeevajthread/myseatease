package com.csiit.seatease.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("listStudent/{examId}")
	public List<Student> getStudentByExamId(@PathVariable("examId") long examId) {
		return studentService.getStudentByExamId(examId);
	}
	
}
