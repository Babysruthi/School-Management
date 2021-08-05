package com.revature.project.Questionaire.client;

import java.util.Scanner;

import com.revature.project.Questionaire.Teacher;
import com.revature.project.Questionaire.Controller.StudentController;

public class MainApplication {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner=new Scanner(System.in);
		int subId=0;
		boolean bool=true;
		System.out.println("welcome!!");
		StudentController scontroller=new StudentController();
		
		System.out.print("Enter teacher id:");
		int teacherId=scanner.nextInt();
		System.out.print("Enter teacher pass:");
		int teacherPass=scanner.nextInt();
        subId=scontroller.checkTeacher(teacherId,teacherPass);
        if(subId!=0)
        	bool=true;
        else
        {
        	bool=false;
        	System.out.println("Enter valid id or pass");
        }
		
		while(bool)
		{
			System.out.println("\nTo perform CRUD operations for\n1 Students\n2 Subjects\n3 To add quizes\n4 To Exit");
			int teacherChoice=scanner.nextInt();
			switch(teacherChoice)
			{
				case 1:
				{
					System.out.println("You can perform CRUD for students for this subject "+ subId);
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
					System.out.println("You can add/delete quiz for this subject "+ subId);
					quizApplication quizApp=new quizApplication();
					quizApp.quiz();
				}
				case 4:
				{
					System.out.println("You were logged out!");
					bool=false;
					break;
				
				}
			}
		
		}
	}

}
