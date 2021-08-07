package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.exception.InvalidException;

public interface StudentService {
	
	public void addStudent(Student student);

	public void deleteStudent(Student student) ;

	public void retrieveStudent(Student student) ;

	public void updateStudent(Student student) ;


}
