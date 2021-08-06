package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Dao.QuizDao;
import com.revature.project.Questionaire.Dao.QuizDaoImp;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.exception.InvalidException;

public class QuizServiceImp implements QuizService{

	QuizDao quizDaoImp = new QuizDaoImp();
	
	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception {
		int subId = quizDaoImp.checkTeacher(teacherId, teacherPass);
		return subId;
	}

	
	public void addQuiz() throws InvalidException, Exception {
		quizDaoImp.addQuiz();
	}

	public void deleteQuiz() throws InvalidException, Exception {
		quizDaoImp.deleteQuiz();
	}

	public void listQuiz() throws InvalidException, Exception {
		quizDaoImp.listQuiz();
	}

	public void addQuestion() throws InvalidException, Exception {
		quizDaoImp.addQuestion();
	}

	public void addAnswer() throws InvalidException, Exception {
		quizDaoImp.addAnswer();
	}

	public void takeQuiz() throws InvalidException, Exception {
		quizDaoImp.takeQuiz();
	}

	public void result() throws InvalidException, Exception {
		quizDaoImp.result();
	}
}
