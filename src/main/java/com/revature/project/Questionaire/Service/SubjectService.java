package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Subject;
import com.revature.project.exception.InvalidException;

public interface SubjectService {

	public void addSubject(Subject subject) throws InvalidException, Exception;

	public void removeSubject(Subject subject) throws InvalidException, Exception;

	public void listSubject() throws InvalidException, Exception;

	public void updateSubject() throws InvalidException, Exception;
}
