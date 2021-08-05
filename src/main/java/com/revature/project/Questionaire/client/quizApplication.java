package com.revature.project.Questionaire.client;

import java.util.Scanner;

import com.revature.project.Questionaire.Quiz;
import com.revature.project.Questionaire.Controller.StudentController;

public class quizApplication {

	public void quiz() throws Exception
	{
		
		System.out.println("------QUIZ-----");
		Scanner scanner=new Scanner(System.in);
		StudentController scontroller=new StudentController();
		
		Quiz quiz=new Quiz();
		
		boolean s=true;
		while(s)
		{
			System.out.println("\n1 Add Quiz\n2 Delete Quiz\n3 List Quiz for particular subject\n4 Add Question\n5 Add Answer\n6 To takeQuiz\n7 Result\n8 Back to main");
			int teacherChoice=scanner.nextInt();
			switch(teacherChoice)
			{
				case 1:
					scontroller.addQuiz();
					break;
				case 2:
					scontroller.deleteQuiz();
					break;
				case 3:
					scontroller.listQuiz();
					break;
				case 4:
					scontroller.addQuestion();
					break;
				case 5:
					scontroller.addAnswer();
					break;
				case 6:
					scontroller.takeQuiz();
					break;
				case 7:
					scontroller.result();
					break;
					
				case 8:
					System.out.println("Back to Main Application!!");
					s=false;
					break;
			}

		}
}
}
