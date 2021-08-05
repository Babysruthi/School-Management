package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.exception.InvalidException;

public class StudentServiceImp implements StudentService {
	StudentDao studentDaoImp = new StudentDaoImp();

	public void addStudent(Student student) throws InvalidException, Exception {
		studentDaoImp.addStudent(student);
	}

	public void deleteStudent(Student student) throws InvalidException, Exception {
		studentDaoImp.deleteStudent(student);
	}

	public void retrieveStudent(Student student) throws InvalidException, Exception {
		studentDaoImp.retrieveStudent(student);
	}

	public void updateStudent(Student student) throws InvalidException, Exception {
		studentDaoImp.updateStudent(student);
	}

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception {
		int subId = studentDaoImp.checkTeacher(teacherId, teacherPass);
		return subId;
	}

	public void addSubject(Subject subject) throws InvalidException, Exception {
		studentDaoImp.addSubject(subject);
	}

	public void removeSubject(Subject subject) throws InvalidException, Exception {
		studentDaoImp.removeSubject(subject);
	}

	public void listSubject() throws InvalidException, Exception {
		studentDaoImp.listSubject();
	}

	public void updateSubject() throws InvalidException, Exception {
		studentDaoImp.updateSubject();
	}

	public void addQuiz() throws InvalidException, Exception {
		studentDaoImp.addQuiz();
	}

	public void deleteQuiz() throws InvalidException, Exception {
		studentDaoImp.deleteQuiz();
	}

	public void listQuiz() throws InvalidException, Exception {
		studentDaoImp.listQuiz();
	}

	public void addQuestion() throws InvalidException, Exception {
		studentDaoImp.addQuestion();
	}

	public void addAnswer() throws InvalidException, Exception {
		studentDaoImp.addAnswer();
	}

	public void takeQuiz() throws InvalidException, Exception {
		studentDaoImp.takeQuiz();
	}

	public void result() throws InvalidException, Exception {
		studentDaoImp.result();
	}
}
