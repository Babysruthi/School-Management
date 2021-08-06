package com.revature.project.Questionaire.Controller;

import com.revature.project.Questionaire.Service.QuizService;
import com.revature.project.Questionaire.Service.QuizServiceImp;
import com.revature.project.Questionaire.Service.SubjectService;
import com.revature.project.Questionaire.Service.SubjectServiceImp;
import com.revature.project.exception.InvalidException;

public class QuizController {

	QuizService quizService=new QuizServiceImp();
	
	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception {
		int subId = quizService.checkTeacher(teacherId, teacherPass);
		return subId;
	}

	public void addQuiz() throws InvalidException, Exception {
		quizService.addQuiz();
	}

	public void deleteQuiz() throws InvalidException, Exception {
		quizService.deleteQuiz();
	}

	public void listQuiz() throws InvalidException, Exception {
		quizService.listQuiz();
	}

	public void addQuestion() throws InvalidException, Exception {
		quizService.addQuestion();
	}

	public void addAnswer() throws InvalidException, Exception {
		quizService.addAnswer();
	}

	public void takeQuiz() throws InvalidException, Exception {
		quizService.takeQuiz();
	}

	public void result() throws InvalidException, Exception {
		quizService.result();
	}

}
