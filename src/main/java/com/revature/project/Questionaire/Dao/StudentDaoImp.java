package com.revature.project.Questionaire.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Answer;
import com.revature.project.Questionaire.Question;
import com.revature.project.Questionaire.Quiz;
import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.DBUtil.DBUtil;
import com.revature.project.exception.CustomClassNotFoundException;
import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidRollNoException;

public class StudentDaoImp implements StudentDao {
	static int subId = 0;
	static String sub = "";
	List<Integer> studentIdList = new ArrayList<Integer>();
	List<Integer> classNoList = new ArrayList<Integer>();
	Scanner scanner = new Scanner(System.in);

	Logger logger = Logger.getLogger("StudentDaoImp.class");

	public void addStudent(Student student) {
		logger.info("In StudentDaoImp->addStudent");
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?,?,?)");

			if ((student.getRollNo() >= 1000 && student.getRollNo() <= 9999) && student.getRollNo() > 0) {
				pst.setInt(1, student.getRollNo());
				
				pst.setString(2, student.getName());
				pst.setString(3, student.getDob());
				pst.setString(4, student.getStandard());
				pst.setString(5, student.getAddress());
				pst.setInt(6, student.getClassNo());
				classNoList.add(student.getClassNo());
				pst.executeUpdate();
			}

			else
				throw new InvalidRollNoException("RollNo should not be negative and must be of 4 digits..");
		} catch (SQLException | InvalidRollNoException e) {
			logger.warn(e.getMessage());

		}

	}

	public void deleteStudent() {
		logger.info("In StudentDaoImp->deleteStudent");
		System.out.print("Enter student's id to delete:");
		int rollNo=scanner.nextInt();
		
		try (Connection con = DBUtil.getConnection();) {
			if (rollNo>=1000&&rollNo<=9999&&studentIdList.contains(rollNo)) {

				PreparedStatement pst = con.prepareStatement("delete from student where id=?");
				pst.setInt(1, rollNo);
				pst.executeUpdate();
				con.close();
				System.out.println("Student removed....");
			}

			else
				throw new InvalidRollNoException("Student Id is not present");
		} catch (SQLException | InvalidRollNoException e) {
			logger.info(e.getMessage());
		}

	}

	public void retrieveStudent(Student student) {
		logger.info("In StudentDaoImp->listStudent");
		try (Connection con = DBUtil.getConnection();) {

			System.out.println("List of students are ....");

			System.out.print("Enter classNo of students needed:");
			int classNo = scanner.nextInt();
			System.out.println(classNo);

			String query = "select * from student where classNo=" + classNo;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet resultSet = pst.executeQuery(query);
			System.out.println();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getString(4) + " " + resultSet.getString(5));
				studentIdList.add(resultSet.getInt(1));
			}
		}

		catch (SQLException e) {
			logger.warn(e.getMessage());
		}
	}

	public void updateStudent(Student student) {
		logger.info("In StudentDaoImp->updateStudent");
		try (Connection con = DBUtil.getConnection();) {

			System.out.println("\nEnter the attribute to update \n1 StudentName\n2 DOB\n3 Standard\n4 Address");
			int teacherChoice = scanner.nextInt();
			System.out.println("Enter the student's id to update:");
			int id = scanner.nextInt();
			if(studentIdList.contains(id)) {
				if (teacherChoice == 1) {
					System.out.println("Enter new name to update:");
					scanner.nextLine();
					String newName = scanner.nextLine();
					String query = "update student set sname=? where id=?";
					PreparedStatement preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, newName);
					preparedStatement.setInt(2, id);
					int executeResult = preparedStatement.executeUpdate();
					con.close();
					if (executeResult > 0)
						System.out.println("student's name is updated");
					else
						System.out.println("Invalid id!!");
				}
				if (teacherChoice == 2) {
					System.out.println("Enter correct DOB to update:");
					scanner.nextLine();
					String newDob = scanner.nextLine();
					String query = "update student set dob=? where id=?";
					PreparedStatement preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, newDob);
					preparedStatement.setInt(2, id);
					int executeResult = preparedStatement.executeUpdate();
					if (executeResult > 0)
						System.out.println("DOB is updated");
					else
						System.out.println("Invalid user id!!");
				}
				if (teacherChoice == 3) {
					System.out.println("Enter student's standard to update:");
					scanner.nextLine();
					String newStandard = scanner.nextLine();
					String query = "update student set standard=? where id=?";
					PreparedStatement preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, newStandard);
					preparedStatement.setInt(2, id);
					int executeResult = preparedStatement.executeUpdate();
					if (executeResult > 0)
						System.out.println("Standard is updated");
					else
						System.out.println("Invalid user id!!");
				}
				if (teacherChoice == 4) {
					System.out.println("Enter new address to update:");
					scanner.nextLine();
					String newAddress = scanner.nextLine();
					String query = "update student set address=? where id=?";
					PreparedStatement preparedStatement = con.prepareStatement(query);
					preparedStatement.setString(1, newAddress);
					preparedStatement.setInt(2, id);
					int executeResult = preparedStatement.executeUpdate();
					if (executeResult > 0)
						System.out.println("Address is updated");
					else
						System.out.println("Invalid user id!!");
				
			} 
			}else
				throw new InvalidRollNoException("Invalid RollNo");
		} catch (SQLException | InvalidRollNoException e) {
			logger.info(e.getMessage());
		}

	}

}
