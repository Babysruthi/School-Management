package com.revature.project.Questionaire.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Controller.StudentController;
import com.revature.project.Questionaire.Controller.SubjectController;

public class SubjectApplication {

	static Logger logger = Logger.getLogger("StudentApplication.class");

	public void subjectDetails() {

		System.out.println("------Subject Application-----");
		Scanner scanner = new Scanner(System.in);
		SubjectController scontroller = new SubjectController();
		scontroller.classNumList();

		Subject subject = new Subject();
		boolean s = true;
		while (s) {
			System.out.println("\n1 Add Subjects\n2 ListOf Subjects\n3 Remove Subject \n4 Back to main");
			int teacherChoice = scanner.nextInt();
			switch (teacherChoice) {
			case 1: {
				logger.info("In subjectApplication -> Add Subjects");
				System.out.print("Enter id:");
				int subjectId = scanner.nextInt();
				System.out.print("Enter classNo:");
				int classNo = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter subject:");
				String subName = scanner.nextLine();

				subject.setSubId(subjectId);
				subject.setSubName(subName);
				subject.setClassNo(classNo);
				scontroller.addSubject(subject);

				break;
			}

			case 2: {
				logger.info("In subjectApplication -> List Subjects");
				scontroller.listSubject();
				break;
			}
			case 3: {
				logger.info("In subjectApplication -> Delete Subject");

				scontroller.removeSubject();
				break;
			}

			case 4: {
				logger.info("In subjectApplication -> Back to main");
				System.out.println("Back to Main Application!!");
				s = false;
				break;
			}
			default: {
				logger.warn("Enter valid choice (1-4)");
				break;
			}
			}

		}
	}
}
