package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.Questionaire.Dao.SubjectDao;
import com.revature.project.Questionaire.Dao.SubjectDaoImp;
import com.revature.project.exception.InvalidException;


public class SubjectServiceImp implements SubjectService{
	
	SubjectDao subjectDaoImp = new SubjectDaoImp();
	
	public void classNumList()
	{
		subjectDaoImp.classNumList();
	}
	
	public void addSubject(Subject subject)  {
		subjectDaoImp.addSubject(subject);
	}

	public void removeSubject() {
		subjectDaoImp.removeSubject();
	}

	public void listSubject()  {
		subjectDaoImp.listSubject();
	}

	public void updateSubject()  {
		subjectDaoImp.updateSubject();
	}

}
