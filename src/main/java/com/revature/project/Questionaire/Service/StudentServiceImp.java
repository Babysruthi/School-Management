package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.exception.InvalidException;

public class StudentServiceImp implements StudentService {
	StudentDao studentDaoImp = new StudentDaoImp();

	public void addStudent(Student student) {
		studentDaoImp.addStudent(student);
	}

	public void deleteStudent(Student student) {
		studentDaoImp.deleteStudent(student);
	}

	public void retrieveStudent(Student student) {
		studentDaoImp.retrieveStudent(student);
	}

	public void updateStudent(Student student) {
		studentDaoImp.updateStudent(student);
	}

	
}
