package com.revature.project.Questionaire.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Quiz;
import com.revature.project.Questionaire.Controller.StudentController;

public class quizApplication {

	static Logger logger = Logger.getLogger("quizApplication.class");

	public void quiz() throws Exception {

		System.out.println("------QUIZ-----");
		Scanner scanner = new Scanner(System.in);
		StudentController scontroller = new StudentController();

		Quiz quiz = new Quiz();

		boolean s = true;
		while (s) {
			System.out.println(
					"\n1 Add Quiz\n2 Delete Quiz\n3 List Quiz for particular subject\n4 Add Question\n5 Add Answer\n6 To takeQuiz\n7 Result\n8 Back to main");
			int teacherChoice = scanner.nextInt();
			switch (teacherChoice) {
			case 1:
				logger.info("In quizApplication -> AddQuiz");
				scontroller.addQuiz();
				break;
			case 2:
				logger.info("In quizApplication -> DeleteQuiz");
				scontroller.deleteQuiz();
				break;
			case 3:
				logger.info("In quizApplication -> List ofQuizes");
				scontroller.listQuiz();
				break;
			case 4:
				logger.info("In quizApplication -> AddQuestion");
				scontroller.addQuestion();
				break;
			case 5:
				logger.info("In quizApplication -> AddAnswer");
				scontroller.addAnswer();
				break;
			case 6:
				logger.info("In quizApplication -> TakeQuiz");
				scontroller.takeQuiz();
				break;
			case 7:
				logger.info("In quizApplication -> Result");
				scontroller.result();
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
