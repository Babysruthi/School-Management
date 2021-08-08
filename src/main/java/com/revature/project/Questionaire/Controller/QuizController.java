package com.revature.project.Questionaire.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.revature.project.Questionaire.Service.QuizService;
import com.revature.project.Questionaire.Service.QuizServiceImp;
import com.revature.project.Questionaire.Service.SubjectService;
import com.revature.project.Questionaire.Service.SubjectServiceImp;
import com.revature.project.exception.InvalidChoiceException;
import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidStaffLoginException;

public class QuizController {

	Logger logger = Logger.getLogger("Quizcontroller.class");
	QuizService quizService = new QuizServiceImp();

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidStaffLoginException {

		int subId = 0;
		subId = quizService.checkTeacher(teacherId, teacherPass);

		return subId;
	}

	public void addQuiz() {

		quizService.addQuiz();
	}

	public void deleteQuiz() {

		quizService.deleteQuiz();
	}

	public List<String> listQuiz() {

		List<String> quizId = new ArrayList<String>();
		quizId = quizService.listQuiz();
		return quizId;
	}

	public void addQuestion() {

		quizService.addQuestion();
	}

	public void addAnswer() {

		quizService.addAnswer();
	}

	public void takeQuiz() {

		quizService.takeQuiz();
	}

	public void result() {

		quizService.result();
	}

}
