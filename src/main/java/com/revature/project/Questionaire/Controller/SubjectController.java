package com.revature.project.Questionaire.Controller;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.SubjectService;
import com.revature.project.Questionaire.Service.SubjectServiceImp;
import com.revature.project.exception.InvalidException;

public class SubjectController {
	Logger logger=Logger.getLogger("SubjectController.class");

	SubjectService subjectService = new SubjectServiceImp();

	public void classNumList() {
		logger.info("In SubjectController -> classNumList method");
		subjectService.classNumList();
	}

	public void addSubject(Subject subject) {
		logger.info("In SubjectController -> addSubject method");
		subjectService.addSubject(subject);
	}

	public void removeSubject() {
		logger.info("In SubjectController -> removeSubject method");
		subjectService.removeSubject();
	}

	public void listSubject() {
		logger.info("In SubjectController -> listsubject method");
		subjectService.listSubject();
	}

	
}
