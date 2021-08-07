package com.revature.project.Questionaire.Controller;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.StudentService;
import com.revature.project.Questionaire.Service.StudentServiceImp;
import com.revature.project.exception.InvalidException;

public class StudentController {
	StudentService studentService = new StudentServiceImp();

	public void addStudent(Student student) {
		studentService.addStudent(student);
	}

	public void deleteStudent(Student student) {
		studentService.deleteStudent(student);
	}

	public void retrieveStudent(Student student) {
		studentService.retrieveStudent(student);
	}

	public void updateStudent(Student student) {
		studentService.updateStudent(student);
	}

}
