package com.revature.project.Questionaire.Controller;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.StudentService;
import com.revature.project.Questionaire.Service.StudentServiceImp;
import com.revature.project.exception.InvalidException;

public class StudentController {
	static Logger logger=Logger.getLogger("StudentController.class");
	StudentService studentService = new StudentServiceImp();

	public void addStudent(Student student) {
		logger.info("In studentController -> addStudent method");
		studentService.addStudent(student);
	}

	public void deleteStudent() {
		logger.info("In studentController -> deleteStudent method");
		studentService.deleteStudent();
	}

	public void retrieveStudent(Student student) {
		logger.info("In studentController -> retrieveStudent method");
		studentService.retrieveStudent(student);
	}

	public void updateStudent(Student student) {
		logger.info("In studentController -> updateStudent method");
		studentService.updateStudent(student);
	}

}
