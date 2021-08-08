package com.revature.project.Questionaire.Service;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.exception.InvalidException;

public class StudentServiceImp implements StudentService {
	
	static Logger logger = Logger.getLogger("StudentServiceImp.class");
	StudentDao studentDaoImp = new StudentDaoImp();

	public void addStudent(Student student) {
		logger.info("In StudentServiceImp->addStudent method");
		studentDaoImp.addStudent(student);
	}

	public void deleteStudent() {
		logger.info("In StudentServiceImp->deleteStudent method");
		studentDaoImp.deleteStudent();
	}

	public void retrieveStudent(Student student) {
		logger.info("In StudentServiceImp->retrieveStudent method");
		studentDaoImp.retrieveStudent(student);
	}

	public void updateStudent(Student student) {
		logger.info("In StudentServiceImp->updateStudent method");
		studentDaoImp.updateStudent(student);
	}

}
