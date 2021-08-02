package com.revature.project.Questionaire.Controller;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Service.StudentService;
import com.revature.project.Questionaire.Service.StudentServiceImp;

public class StudentController
{
	StudentService studentService=new StudentServiceImp();
//	 public void checkTeacher(String teacherId,String teacherPass) throws Exception
//	 {
//		 studentService.checkTeacher(teacherId,teacherPass);
//	  }
	public void addStudent(Student student) throws Exception
	{
		studentService.addStudent(student);
	}
	public void deleteStudent(Student student) throws Exception
	{
		studentService.deleteStudent(student);
	}
	public void retrieveStudent(Student student) throws Exception
	{
		studentService.retrieveStudent(student);
	}
	public void updateStudent(Student student) throws Exception
	{
		studentService.updateStudent(student);
	}
	
	
	public void addSubject(Subject subject) throws Exception
	{
		studentService.addSubject(subject);
	}
	
	public void removeSubject(Subject subject) throws Exception
	{
		studentService.removeSubject(subject);
	}
	public void listSubject() throws Exception
	{
		studentService.listSubject();
	}
	public void updateSubject() throws Exception
	{
		studentService.updateSubject();
	}
	
	
	
	public void addQuiz() throws Exception
	{
		studentService.addQuiz();
	}
	public void addQuestion() throws Exception
	{
		studentService.addQuestion();
	}
	public void addAnswer() throws Exception
	{
		studentService.addAnswer();
	}
	public void result() throws Exception
	{
		studentService.result();
	}
	
	
	
	
	
	
	
	
	
}
