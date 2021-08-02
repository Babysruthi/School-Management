package com.revature.project.Questionaire.client;

import java.util.Scanner;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Controller.StudentController;

public class SubjectApplication {

	public void subjectDetails() throws Exception
	{
		
		System.out.println("------Subject Application-----");
		Scanner scanner=new Scanner(System.in);
		StudentController scontroller=new StudentController();
		
		Subject subject=new Subject();
		boolean s=true;
		while(s)
		{
			System.out.println("\n1 Add Subjects\n2 Remove Subjects\n3 ListOf Subjects\n4 Update Subject\n5 Back to main");
			int teacherChoice=scanner.nextInt();
			switch(teacherChoice)
			{
				case 1:
				{
					int subjectId=scanner.nextInt();
					int studentId=scanner.nextInt();
					scanner.nextLine();
					String subName=scanner.nextLine();;
			
					subject.setSubId(subjectId);
					subject.setSubName(subName);
					subject.setStudId(studentId);
					
					scontroller.addSubject(subject);
		 
					System.out.println("Subject is added...");
					break;
				}
			
				case 2:
				{
					System.out.println("Enter subject's id to remove");
					int subjectId=scanner.nextInt();
					subject.setSubId(subjectId);
					scontroller.removeSubject(subject);
					break;
				}
			
				case 3:
				{
					scontroller.listSubject();
					break;
				}
				
				case 4:
				{
					scontroller.updateSubject();
					break;
				}
				
				case 5:
				{
					System.out.println("Back to Main Application!!");
					s=false;
					break;
				}
		}	
		 
	}
	}
}
