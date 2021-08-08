package com.revature.project.Questionaire.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Subject;
import com.revature.project.Questionaire.SubjectClass;
import com.revature.project.Questionaire.DBUtil.DBUtil;
import com.revature.project.exception.CustomClassNotFoundException;
import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidSubIdException;

public class SubjectDaoImp implements SubjectDao {

	Logger logger = Logger.getLogger("SubjectDaoImp.class");
	Scanner scanner = new Scanner(System.in);
	List<Integer> subIdList = new ArrayList<Integer>();
	List<Integer> classNoList = new ArrayList<Integer>();

	public void classNumList() {
		logger.info("In SubjectDaoImp->classNumList");
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = con.prepareStatement("select classNo from class");
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next())
				classNoList.add(resultSet.getInt(1));

		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
	}

	public void addSubject(Subject subject) {
		logger.info("In SubjectDaoImp->addSubject");
		try (Connection con = DBUtil.getConnection();) {
			PreparedStatement pst = con.prepareStatement("insert into subject values(?,?,?)");
			pst.setInt(1, subject.getSubId());
			pst.setString(2, subject.getSubName());
		   pst.setInt(3, subject.getClassNo());
			int result = pst.executeUpdate();
			if (result > 0) {
				logger.info("Subject is added successfully");
				
				
				
			} else
				logger.info("Enter valid sub Id");
		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}

	}

	public void removeSubject() {
		logger.info("In SubjectDaoImp->removeSubject");
		try (Connection con = DBUtil.getConnection();) {
			System.out.println("Enter subId to remove the subject");
			int subId = scanner.nextInt();
			if (subIdList.contains(subId)) {
				PreparedStatement pst = con.prepareStatement("delete from subject where id=?");
				pst.setInt(1, subId);
				pst.executeUpdate();
			} else
				throw new InvalidSubIdException("Subject Id is not found");
		}

		catch (SQLException | InvalidSubIdException e) {
			logger.warn(e.getMessage());
		}

	}

	public void listSubject() {

		try (Connection con = DBUtil.getConnection();) {
			logger.info("In SubjectDaoImp->listSubject");

			String query = "select id,name from subject";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet resultSet = pst.executeQuery(query);
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
				subIdList.add(resultSet.getInt(1));
				
			}
		}

		catch (SQLException e) {
			logger.warn(e.getMessage());
		}

	}

	

}
