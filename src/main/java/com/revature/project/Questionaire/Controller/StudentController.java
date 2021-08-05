package com.revature.project.Questionaire.Controller;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.StudentService;
import com.revature.project.Questionaire.Service.StudentServiceImp;
import com.revature.project.exception.InvalidException;

public class StudentController {
	StudentService studentService = new StudentServiceImp();

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception {
		int subId = studentService.checkTeacher(teacherId, teacherPass);
		return subId;
	}

	public void addStudent(Student student) throws InvalidException, Exception {
		studentService.addStudent(student);
	}

	public void deleteStudent(Student student) throws InvalidException, Exception {
		studentService.deleteStudent(student);
	}

	public void retrieveStudent(Student student) throws InvalidException, Exception {
		studentService.retrieveStudent(student);
	}

	public void updateStudent(Student student) throws InvalidException, Exception {
		studentService.updateStudent(student);
	}

	public void addSubject(Subject subject) throws InvalidException, Exception {
		studentService.addSubject(subject);
	}

	public void removeSubject(Subject subject) throws InvalidException, Exception {
		studentService.removeSubject(subject);
	}

	public void listSubject() throws InvalidException, Exception {
		studentService.listSubject();
	}

	public void updateSubject() throws InvalidException, Exception {
		studentService.updateSubject();
	}

	public void addQuiz() throws InvalidException, Exception {
		studentService.addQuiz();
	}

	public void deleteQuiz() throws InvalidException, Exception {
		studentService.deleteQuiz();
	}

	public void listQuiz() throws InvalidException, Exception {
		studentService.listQuiz();
	}

	public void addQuestion() throws InvalidException, Exception {
		studentService.addQuestion();
	}

	public void addAnswer() throws InvalidException, Exception {
		studentService.addAnswer();
	}

	public void takeQuiz() throws InvalidException, Exception {
		studentService.takeQuiz();
	}

	public void result() throws InvalidException, Exception {
		studentService.result();
	}

}
