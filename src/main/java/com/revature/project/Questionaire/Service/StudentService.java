package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;

public interface StudentService 
{
	public void addStudent(Student student) throws Exception;
	public void deleteStudent(Student student) throws Exception;
	public void retrieveStudent(Student student) throws Exception;
	public void updateStudent(Student student) throws Exception;
	
	//public void checkTeacher(String teacherId,String teacherPass) throws Exception;
	
	public void addSubject(Subject subject) throws Exception;
	public void removeSubject(Subject subject) throws Exception;
	public void listSubject() throws Exception;
	public void updateSubject() throws Exception;
	
	
	public void addQuiz() throws Exception;
	public void addQuestion() throws Exception;
	public void addAnswer() throws Exception;
	
	public void result() throws Exception;
	
	
}

