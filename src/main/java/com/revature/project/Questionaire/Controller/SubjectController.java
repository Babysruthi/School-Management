package com.revature.project.Questionaire.Controller;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.SubjectService;
import com.revature.project.Questionaire.Service.SubjectServiceImp;
import com.revature.project.exception.InvalidException;

public class SubjectController {

	SubjectService subjectService = new SubjectServiceImp();

	public void classNumList() {
		subjectService.classNumList();
	}

	public void addSubject(Subject subject) {
		subjectService.addSubject(subject);
	}

	public void removeSubject() {
		subjectService.removeSubject();
	}

	public void listSubject() {
		subjectService.listSubject();
	}

	public void updateSubject() {
		subjectService.updateSubject();
	}
}
