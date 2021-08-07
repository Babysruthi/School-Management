package com.revature.project.Questionaire.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.project.Questionaire.Dao.QuizDao;
import com.revature.project.Questionaire.Dao.QuizDaoImp;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.exception.InvalidChoiceException;
import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidStaffLoginException;

public class QuizServiceImp implements QuizService {

	QuizDao quizDaoImp = new QuizDaoImp();

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidStaffLoginException {
		int subId = 0;

		subId = quizDaoImp.checkTeacher(teacherId, teacherPass);

		return subId;
	}

	public void addQuiz() {
		quizDaoImp.addQuiz();
	}

	public void deleteQuiz() {
		quizDaoImp.deleteQuiz();
	}

	public List<String> listQuiz() {
		List<String> quizId = new ArrayList<String>();
		quizId = quizDaoImp.listQuiz();
		return quizId;

	}

	public void addQuestion() {
		quizDaoImp.addQuestion();
	}

	public void addAnswer() {
		quizDaoImp.addAnswer();
	}

	public void takeQuiz() {
		quizDaoImp.takeQuiz();
	}

	public void result() {
		quizDaoImp.result();
	}
}
