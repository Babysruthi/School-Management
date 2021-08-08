package com.revature.project.Questionaire.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Dao.QuizDao;
import com.revature.project.Questionaire.Dao.QuizDaoImp;
import com.revature.project.Questionaire.Dao.StudentDao;
import com.revature.project.Questionaire.Dao.StudentDaoImp;
import com.revature.project.exception.InvalidChoiceException;
import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidStaffLoginException;

public class QuizServiceImp implements QuizService {

	QuizDao quizDaoImp = new QuizDaoImp();
	Logger logger = Logger.getLogger("QuizServiceImp.class");

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidStaffLoginException {

		logger.info("In QuizServiceImp -> checkTeacher");
		int subId = quizDaoImp.checkTeacher(teacherId, teacherPass);

		return subId;
	}

	public void addQuiz() {
		logger.info("In QuizServiceImp ->addQuiz");
		quizDaoImp.addQuiz();
	}

	public void deleteQuiz() {
		logger.info("In QuizServiceImp ->deleteQuiz");
		quizDaoImp.deleteQuiz();
	}

	public List<String> listQuiz() {
		logger.info("In QuizServiceImp ->listQuiz");
		List<String> quizId = new ArrayList<String>();
		quizId = quizDaoImp.listQuiz();
		return quizId;

	}

	public void addQuestion() {
		logger.info("In QuizServiceImp ->addQuestion");
		quizDaoImp.addQuestion();
	}

	public void addAnswer() {
		logger.info("In QuizServiceImp ->addAnswer");
		quizDaoImp.addAnswer();
	}

	public void takeQuiz() {
		logger.info("In QuizServiceImp ->takeQuiz");
		quizDaoImp.takeQuiz();
	}

	public void result() {
		logger.info("In QuizServiceImp -> Result");
		quizDaoImp.result();
	}
}
