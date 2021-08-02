package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;

public class StudentServiceImp implements StudentService
{
	StudentDao studentDaoImp=new StudentDaoImp();
	public void addStudent(Student student) throws Exception
	{
		studentDaoImp.addStudent(student);
	}
	public void deleteStudent(Student student) throws Exception
	{
		studentDaoImp.deleteStudent(student);
	}
	public void retrieveStudent(Student student) throws Exception
	{
		studentDaoImp.retrieveStudent(student);
	}
	public void updateStudent(Student student) throws Exception
	{
		studentDaoImp.updateStudent(student);
	}
//	public void checkTeacher(String teacherId,String teacherPass)throws Exception
//	{
//		studentDaoImp.checkTeacher(teacherId,teacherPass);
//	}
	
	
	public void addSubject(Subject subject) throws Exception
	{
		studentDaoImp.addSubject(subject);
	}
	public void removeSubject(Subject subject) throws Exception
	{
		studentDaoImp.removeSubject(subject);
	}
	public void listSubject() throws Exception
	{
		studentDaoImp.listSubject();
	}
	public void updateSubject() throws Exception
	{
		studentDaoImp.updateSubject();
	}
	
	
	
	
	
	public void addQuiz() throws Exception
	{
		studentDaoImp.addQuiz();
	}
	public void addQuestion() throws Exception
	{
		studentDaoImp.addQuestion();
	}
	public void addAnswer() throws Exception
	{
		studentDaoImp.addAnswer();
	}
	
	public void result() throws Exception
	{
		studentDaoImp.result();
	}
}






