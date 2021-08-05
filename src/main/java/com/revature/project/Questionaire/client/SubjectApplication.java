package com.revature.project.Questionaire.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.Controller.StudentController;

public class SubjectApplication {

	static Logger logger = Logger.getLogger("StudentApplication.class");

	public void subjectDetails() throws Exception {

		System.out.println("------Subject Application-----");
		Scanner scanner = new Scanner(System.in);
		StudentController scontroller = new StudentController();

		Subject subject = new Subject();
		boolean s = true;
		while (s) {
			System.out.println(
					"\n1 Add Subjects\n2 Remove Subjects\n3 ListOf Subjects\n4 Update Subject\n5 Back to main");
			int teacherChoice = scanner.nextInt();
			switch (teacherChoice) {
			case 1: {
				logger.info("In subjectApplication -> Add Subjects");
				System.out.println("Enter id:");
				int subjectId = scanner.nextInt();
				System.out.println("Enter classNo:");
				int classNo = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter subject");
				String subName = scanner.nextLine();
				;

				subject.setSubId(subjectId);
				subject.setSubName(subName);
				subject.setClassNo(classNo);

				scontroller.addSubject(subject);

				break;
			}

			case 2: {
				logger.info("In subjectApplication -> Delete Subject");
				System.out.println("Enter subject's id to remove:");
				int subjectId = scanner.nextInt();
				subject.setSubId(subjectId);
				scontroller.removeSubject(subject);
				break;
			}

			case 3: {
				logger.info("In subjectApplication -> List Subjects");
				scontroller.listSubject();
				break;
			}

			case 4: {
				logger.info("In subjectApplication -> update Subjects");
				scontroller.updateSubject();
				break;
			}

			case 5: {
				logger.info("In subjectApplication -> Back to main");
				System.out.println("Back to Main Application!!");
				s = false;
				break;
			}
			}

		}
	}
}
