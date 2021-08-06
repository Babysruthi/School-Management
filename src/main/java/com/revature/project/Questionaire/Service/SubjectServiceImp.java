package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.Questionaire.Dao.SubjectDao;
import com.revature.project.Questionaire.Dao.SubjectDaoImp;
import com.revature.project.exception.InvalidException;


public class SubjectServiceImp implements SubjectService{
	
	SubjectDao subjectDaoImp = new SubjectDaoImp();
	
	public void addSubject(Subject subject) throws InvalidException, Exception {
		subjectDaoImp.addSubject(subject);
	}

	public void removeSubject(Subject subject) throws InvalidException, Exception {
		subjectDaoImp.removeSubject(subject);
	}

	public void listSubject() throws InvalidException, Exception {
		subjectDaoImp.listSubject();
	}

	public void updateSubject() throws InvalidException, Exception {
		subjectDaoImp.updateSubject();
	}

}
