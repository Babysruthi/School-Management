package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.exception.InvalidException;

public interface StudentService {
	
	public void addStudent(Student student) throws InvalidException, Exception;

	public void deleteStudent(Student student) throws InvalidException, Exception;

	public void retrieveStudent(Student student) throws InvalidException, Exception;

	public void updateStudent(Student student) throws InvalidException, Exception;


}
