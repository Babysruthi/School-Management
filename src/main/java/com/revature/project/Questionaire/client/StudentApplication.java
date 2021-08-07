package com.revature.project.Questionaire.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Controller.StudentController;
import com.revature.project.exception.InvalidException;

public class StudentApplication {
	static Logger logger = Logger.getLogger("StudentApplication.class");

	public void studentDetails() {

		System.out.println("------Enter Student Details-----");
		Scanner scanner = new Scanner(System.in);
		StudentController scontroller = new StudentController();

		Student student = new Student();
		boolean s = true;
		while (s) {
			System.out
					.println("\n1 Add Student\n2 Delete Student\n3 ListOf Students\n4 Update student\n5 Back to main");
			int teacherChoice = scanner.nextInt();
			switch (teacherChoice) {
			case 1: {
				logger.info("In studentApplication -> Add Students");
				System.out.println("Enter rollNo:");
				int rollNo = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter name:");
				String name = scanner.nextLine();
				;
				System.out.println("Enter dob:");
				String dob = scanner.nextLine();
				;
				System.out.println("Enter standard:");
				String standard = scanner.nextLine();
				;
				System.out.println("Enter address:");
				String address = scanner.nextLine();
				;
				System.out.println("Enter classNo:");
				int classNo = scanner.nextInt();

				student.setRollNo(rollNo);
				student.setName(name);
				student.setDob(dob);
				student.setStandard(standard);
				student.setAddress(address);
				student.setClassNo(classNo);
				scontroller.addStudent(student);

				break;
			}

			case 2: {
				logger.info("In studentApplication -> Delete Student");
				System.out.println("Enter the student's id to delete:");
				int studentId = scanner.nextInt();
				student.setRollNo(studentId);
				scontroller.deleteStudent(student);
				break;
			}

			case 3: {
				logger.info("In studentApplication -> ListOf Students");
				scontroller.retrieveStudent(student);
				break;
			}

			case 4: {
				logger.info("In studentApplication -> Update Student");
				scontroller.updateStudent(student);
				break;
			}

			case 5: {
				logger.info("In studentApplication -> Back to main");
				System.out.println("Back to Main Application!!");
				s = false;
				break;
			}
			default: {
				logger.warn("Enter valid choice (1-5)");
				break;
			}
			}

		}
	}
}
