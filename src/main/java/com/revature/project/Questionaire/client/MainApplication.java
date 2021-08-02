package com.revature.project.Questionaire.client;

import java.util.Scanner;

import com.revature.project.Questionaire.Teacher;
import com.revature.project.Questionaire.Controller.StudentController;

public class MainApplication {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("welcome!!");
		StudentController scontroller=new StudentController();
		
//		System.out.println("Enter teacher id");
//		String teacherId=scanner.nextLine();
//		System.out.println("Enter teacher pass");
//		String teacherPass=scanner.nextLine();
//      scontroller.checkTeacher(teacherId,teacherPass);
		
		boolean s=true;
		while(s)
		{
			System.out.println("\nTo perform CRUD operations for\n1 Students\n2 Subjects\n3 To add quizes\n4 To Exit");
			int teacherChoice=scanner.nextInt();
			switch(teacherChoice)
			{
				case 1:
				{
					StudentApplication studentApplication=new StudentApplication();
					studentApplication.studentDetails();
					break;
				}
				
				case 2:
				{
					SubjectApplication subjectApplication=new SubjectApplication();
					subjectApplication.subjectDetails();
					break;
				}
				case 3:
				{
					quizApplication quizApp=new quizApplication();
					quizApp.quiz();
				}
				case 4:
				{
					System.out.println("You were logged out!");
					s=false;
					break;
				
				}
			}
		
		}
	}

}
