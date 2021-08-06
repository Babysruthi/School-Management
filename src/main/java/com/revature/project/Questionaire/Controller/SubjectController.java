package com.revature.project.Questionaire.Controller;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.SubjectService;
import com.revature.project.Questionaire.Service.SubjectServiceImp;
import com.revature.project.exception.InvalidException;

public class SubjectController {

	SubjectService subjectService=new SubjectServiceImp();
	
	public void addSubject(Subject subject) throws InvalidException, Exception {
		subjectService.addSubject(subject);
	}

	public void removeSubject(Subject subject) throws InvalidException, Exception {
		subjectService.removeSubject(subject);
	}

	public void listSubject() throws InvalidException, Exception {
		subjectService.listSubject();
	}

	public void updateSubject() throws InvalidException, Exception {
		subjectService.updateSubject();
	}
}
