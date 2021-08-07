package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Subject;
import com.revature.project.exception.InvalidException;

public interface SubjectService {

	public void classNumList();
	public void addSubject(Subject subject);

	public void removeSubject() ;

	public void listSubject() ;

	public void updateSubject() ;
}
