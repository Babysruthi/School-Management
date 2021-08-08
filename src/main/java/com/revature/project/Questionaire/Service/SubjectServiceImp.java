package com.revature.project.Questionaire.Service;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.Questionaire.Dao.SubjectDao;
import com.revature.project.Questionaire.Dao.SubjectDaoImp;
import com.revature.project.exception.InvalidException;

public class SubjectServiceImp implements SubjectService {
	Logger logger=Logger.getLogger("SubjectServiceImp.class");

	SubjectDao subjectDaoImp = new SubjectDaoImp();

	public void classNumList() {
		logger.info("In subjectServiceImp -> classNumList method");
		subjectDaoImp.classNumList();
	}

	public void addSubject(Subject subject) {
		logger.info("In subjectServiceImp -> addSubject method");
		subjectDaoImp.addSubject(subject);
	}

	public void removeSubject() {
		logger.info("In subjectServiceImp -> removeSubject method");
		subjectDaoImp.removeSubject();
	}

	public void listSubject() {
		logger.info("In subjectServiceImp -> listSubject method");
		subjectDaoImp.listSubject();
	}


}
