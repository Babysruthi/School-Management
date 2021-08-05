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
		
//		int rollNo=scanner.nextInt();scanner.nextLine();
//		String name=scanner.nextLine();;
//		String dob=scanner.nextLine();;
//		String standard=scanner.nextLine();;
//		String address=scanner.nextLine();;
		
		boolean s=true;
		while(s)
		{
			System.out.println("\n1 Add Quiz\n2 Delete Quiz\n3 Add Question\n4 Add Answer\n5 To takeQuiz\n6 Result\n7 Back to main");
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
					scontroller.addQuestion();
					break;
				case 4:
					scontroller.addAnswer();
					break;
				case 5:
					scontroller.takeQuiz();
					break;
				case 6:
					scontroller.result();
					break;
					
				case 7:
					System.out.println("Back to Main Application!!");
					s=false;
					break;
			}

		}
}
}
