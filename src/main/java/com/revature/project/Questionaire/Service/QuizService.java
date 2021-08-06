package com.revature.project.Questionaire.Service;

import com.revature.project.exception.InvalidException;

public interface QuizService {

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception;


	public void addQuiz() throws InvalidException, Exception;

	public void deleteQuiz() throws InvalidException, Exception;

	public void listQuiz() throws InvalidException, Exception;

	public void addQuestion() throws InvalidException, Exception;

	public void addAnswer() throws InvalidException, Exception;

	public void takeQuiz() throws InvalidException, Exception;

	public void result() throws InvalidException, Exception;
}
