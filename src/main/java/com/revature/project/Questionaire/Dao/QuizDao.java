package com.revature.project.Questionaire.Dao;

import java.util.List;

import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidStaffLoginException;

public interface QuizDao {
	
	public int checkTeacher(int teacherId, int teacherPass)throws InvalidStaffLoginException; 
	
	public void addQuiz() ;

	public void deleteQuiz() ;

	public List<String> listQuiz();

	public void addQuestion() ;

	public void addAnswer();

	public void takeQuiz();

	public void result();
}
