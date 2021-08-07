package com.revature.project.Questionaire.Dao;

import com.revature.project.Questionaire.Subject;
import com.revature.project.exception.InvalidException;

public interface SubjectDao {
	public void classNumList();

	public void addSubject(Subject subject);

	public void removeSubject();

	public void listSubject();

	public void updateSubject();
}
