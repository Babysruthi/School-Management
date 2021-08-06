package com.revature.project.Questionaire.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.DBUtil.DBUtil;
import com.revature.project.exception.InvalidException;

public class SubjectDaoImp implements SubjectDao{
	
	Scanner scanner=new Scanner(System.in);
	
	public void addSubject(Subject subject) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement("insert into subject values(?,?,?)");
		pst.setInt(1, subject.getSubId());
		pst.setString(2, subject.getSubName());
		pst.setInt(3, subject.getClassNo());
		int result = pst.executeUpdate();
		con.close();
		if (result > 0)
			System.out.println("Subject added....");
		else
			throw new InvalidException("Enter correct details!..Error..check datatypes,duplicates");

	}

	public void removeSubject(Subject subject) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement pst = con.prepareStatement("delete from subject where id=?");
		pst.setInt(1, subject.getSubId());
		int result = pst.executeUpdate();
		if (result > 0)
			System.out.println("subject removed....");
		else
			throw new InvalidException("Subject Id is not found");
	}

	public void listSubject() throws Exception {
		// Subject subject=new Subject();
		int flag = 0;
		Connection con = DBUtil.getConnection();
		System.out.print("Enter classNo whose subjects are needed:");
		int classNo = scanner.nextInt();
		String query = "select name from subject where classNo=" + classNo;
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet resultSet = pst.executeQuery(query);
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
			flag = 1;
		}
		con.close();
		if (flag == 0)
			System.out.println("No subjects alloted for the cls " + classNo + " yet");
	}

	public void updateSubject() throws Exception {
		Subject subject = new Subject();

	}


}
