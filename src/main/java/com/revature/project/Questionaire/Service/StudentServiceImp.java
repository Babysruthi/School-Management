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
	public int checkTeacher(int teacherId,int teacherPass)throws Exception
	{
		int subId=studentDaoImp.checkTeacher(teacherId,teacherPass);
		return subId;
	}
	
	
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
	public void deleteQuiz() throws Exception
	{
		studentDaoImp.deleteQuiz();
	}
	
	
	
	
	
	public void addQuestion() throws Exception
	{
		studentDaoImp.addQuestion();
	}
	public void addAnswer() throws Exception
	{
		studentDaoImp.addAnswer();
	}
	public void takeQuiz() throws Exception
	{
		studentDaoImp.takeQuiz();
	}
	public void result() throws Exception
	{
		studentDaoImp.result();
	}
}






