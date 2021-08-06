package com.revature.project.Questionaire.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.project.Questionaire.Answer;
import com.revature.project.Questionaire.Question;
import com.revature.project.Questionaire.Quiz;
import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.DBUtil.DBUtil;
import com.revature.project.exception.InvalidException;

public class StudentDaoImp implements StudentDao {
	static int subId = 0;
	static String sub = "";
	Scanner scanner = new Scanner(System.in);

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception {
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		String query = ("select * from teacher");
		int id1 = 0, pass1 = 0;
		int flag = 0;
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			id1 = rs.getInt("id");
			pass1 = rs.getInt("pass");
			subId = rs.getInt("subId");

			if ((teacherId == id1) && (teacherPass == pass1)) {
				flag = 1;
			}

		}
		if (flag == 1) {

			ResultSet resultSet = st.executeQuery(
					"select s.name from subject s join teacher t on s.id=t.subId where t.id=" + teacherId);
			while (resultSet.next()) {
				sub = resultSet.getString(1);
			}
			System.out.println(sub);
		} else {
			throw new InvalidException("Invalid user or pass!");

		}
		con.close();
		return subId;
	}

	public void addStudent(Student student) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?,?,?)");
		pst.setInt(1, student.getRollNo());
		pst.setString(2, student.getName());
		pst.setString(3, student.getDob());
		pst.setString(4, student.getStandard());
		pst.setString(5, student.getAddress());
		pst.setInt(6, student.getClassNo());
		int result = pst.executeUpdate();
		con.close();
		if (result > 0)
			System.out.println("Student added..");
		else
			throw new InvalidException("Enter correct details!..Error..check datatypes,duplicates");

	}

	public void deleteStudent(Student student) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement("delete from student where id=?");
		pst.setInt(1, student.getRollNo());
		int result = pst.executeUpdate();
		con.close();
		if (result > 0)
			System.out.println("Student removed....");
		else

			throw new InvalidException("Student Id is not present");

	}

	public void retrieveStudent(Student student) throws Exception {
		Connection con = DBUtil.getConnection();
		System.out.println("List of students are ....");
		System.out.print("Enter classNo of students needed:");
		int classNo = scanner.nextInt();
		String query = "select * from student where classNo=" + classNo;
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet resultSet = pst.executeQuery(query);
		System.out.println();
		int flag = 0;
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " "
					+ resultSet.getString(4) + " " + resultSet.getString(5));
			flag = 1;
		}
		con.close();
		if (flag == 0)
			throw new InvalidException("No list of students in this particular classNo " + classNo);

	}

	public void updateStudent(Student student) throws Exception {
		Connection con = DBUtil.getConnection();
		System.out.println("\nEnter the attribute to update \n1 StudentName\n2 DOB\n3 Standard\n4 Address");
		int teacherChoice = scanner.nextInt();
		System.out.println("Enter the student's id to update:");
		int id = scanner.nextInt();
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

	}

	
}
