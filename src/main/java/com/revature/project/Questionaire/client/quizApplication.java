package com.revature.project.Questionaire.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Quiz;
import com.revature.project.Questionaire.Controller.QuizController;
import com.revature.project.Questionaire.Controller.StudentController;

public class quizApplication {

	static Logger logger = Logger.getLogger("quizApplication.class");

	public void quiz() throws Exception {

		System.out.println("------QUIZ-----");
		Scanner scanner = new Scanner(System.in);
		QuizController quizcontroller = new QuizController();

		Quiz quiz = new Quiz();

		boolean s = true;
		while (s) {
			System.out.println(
					"\n1 Add Quiz\n2 Delete Quiz\n3 List Quiz for particular subject\n4 Add Question\n5 Add Answer\n6 To takeQuiz\n7 Result\n8 Back to main");
			int teacherChoice = scanner.nextInt();
			switch (teacherChoice) {
			case 1:
				logger.info("In quizApplication -> AddQuiz");
				quizcontroller.addQuiz();
				break;
			case 2:
				logger.info("In quizApplication -> DeleteQuiz");
				quizcontroller.deleteQuiz();
				break;
			case 3:
				logger.info("In quizApplication -> List ofQuizes");
				quizcontroller.listQuiz();
				break;
			case 4:
				logger.info("In quizApplication -> AddQuestion");
				quizcontroller.addQuestion();
				break;
			case 5:
				logger.info("In quizApplication -> AddAnswer");
				quizcontroller.addAnswer();
				break;
			case 6:
				logger.info("In quizApplication -> TakeQuiz");
				quizcontroller.takeQuiz();
				break;
			case 7:
				logger.info("In quizApplication -> Result");
				quizcontroller.result();
				break;

			case 8:
				logger.info("In quizApplication -> Back to main");
				System.out.println("Back to Main Application!!");
				s = false;
				break;
			}

		}
	}
}
