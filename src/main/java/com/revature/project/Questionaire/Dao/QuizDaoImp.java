package com.revature.project.Questionaire.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.project.Questionaire.Answer;
import com.revature.project.Questionaire.Question;
import com.revature.project.Questionaire.Quiz;
import com.revature.project.Questionaire.DBUtil.DBUtil;
import com.revature.project.exception.InvalidException;
import com.revature.project.exception.InvalidSubIdException;
import com.revature.project.exception.QuizIdNotFoundException;
import com.revature.project.exception.InvalidStaffLoginException;

public class QuizDaoImp implements QuizDao {
	Logger logger = Logger.getLogger("QuizDaoImp.class");
	Scanner scanner = new Scanner(System.in);
	static int subId = 0;
	static String sub = "";
	List<String> quizIdList = new ArrayList<String>();

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidStaffLoginException {
		
		logger.info("In QuizDaoImp->checkteacher");
		try (Connection con = DBUtil.getConnection();) {
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
				System.out.println("\nHandling subject:"+sub);
			} else
				throw new InvalidStaffLoginException("Invalid user or pass..");
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}

		return subId;
	}

	public void addQuiz() {
		Quiz quiz = new Quiz();
		logger.info("In QuizDaoImp->addQuiz");
		try {
			Connection con = DBUtil.getConnection();
			System.out.print("Enter subId:");
			int sId = scanner.nextInt();
			if (sId == subId) {
				scanner.nextLine();
				System.out.print("Enter quizId:");
				String quizId = scanner.nextLine();
				scanner.nextLine();
				System.out.print("Enter totalQues:");
				int totalQues = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter quizname:");
				String quizName = scanner.nextLine();

				PreparedStatement pst = con.prepareStatement("insert into quiz values(?,?,?,?)");
				pst.setInt(1, sId);
				pst.setString(2, quizId);
				pst.setString(3, quizName);
				pst.setInt(4, totalQues);
				pst.executeUpdate();
				System.out.println("You are ready to add questions!!!....");
			} else {
				throw new InvalidException("You are not able to create quiz for this subjectId"+sId);
			}
		}

		catch (SQLException | InvalidException e) {
			logger.info(e.getMessage());
		}
	}

	public void deleteQuiz() {
		logger.info("In QuizDaoImp->deleteQuiz");
		try {
			Connection con = DBUtil.getConnection();
			scanner.nextLine();
			System.out.print("Enter quizId to delete:");
			String quizId = scanner.nextLine();
			if (quizIdList.contains(quizId)) {
				PreparedStatement pst = con.prepareStatement("delete from quiz where id=?");
				pst.setString(1, quizId);
				int result = pst.executeUpdate();
			} else {
				throw new QuizIdNotFoundException("QuizId is not Found..");
			}
		} catch (SQLException | QuizIdNotFoundException e) {
			logger.warn(e.getMessage());
		}

	}

	public List<String> listQuiz() {
		logger.info("In QuizDaoImp->listQuiz");
		Quiz quiz = new Quiz();
		List<String> quizId = new ArrayList<String>();
		try {
			Connection con = DBUtil.getConnection();

			System.out.print("Enter subId to list quiz:");
			int sId = scanner.nextInt();
			if (sId == subId) {
				String query = "select id,name from quiz where subId=" + sId;

				PreparedStatement pst = con.prepareStatement(query);
				ResultSet resultSet = pst.executeQuery(query);
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
					quizIdList.add(resultSet.getString(1));
				}
			} else {
				throw new InvalidSubIdException("You cant able to see the quizes of other subject");
			}
		} catch (SQLException | InvalidSubIdException e) {
			logger.warn(e.getMessage());
		}
		return quizIdList;
	}

	public void addQuestion() {
		logger.info("In QuizDaoImp->addQuestion");
		Question question = new Question();
		try {
			Connection con = DBUtil.getConnection();
			scanner.nextLine();
			System.out.print("Enter quizId:");
			String quizId = scanner.nextLine();
			if (quizIdList.contains(quizId)) {
				System.out.print("Enter quesNo:");
				String quesNo = scanner.nextLine();
				System.out.print("Enter question:");
				String ques = scanner.nextLine();

				PreparedStatement pst = con.prepareStatement("insert into question values(?,?,?)");
				pst.setString(1, quizId);
				pst.setString(2, quesNo);
				pst.setString(3, ques);
				pst.executeUpdate();
				System.out.println("Questions are added successfully....");
			} else
				throw new QuizIdNotFoundException("Quiz is not created to add the questions");
		}

		catch (SQLException | QuizIdNotFoundException e) {
			logger.warn(e.getMessage());
		}
	}

	public void addAnswer() {
		logger.info("In QuizDaoImp->addAnswer");
		Answer answer = new Answer();
		try {
			Connection con = DBUtil.getConnection();
			scanner.nextLine();
			System.out.print("Enter quesNo:");
			String quesNo = scanner.nextLine();
			System.out.print("Enter option1:");
			String option1 = scanner.nextLine();
			System.out.print("Enter option2:");
			String option2 = scanner.nextLine();
			System.out.print("Enter option3:");
			String option3 = scanner.nextLine();
			System.out.print("Enter option4:");
			String option4 = scanner.nextLine();
			System.out.print("Enter crct answer:");
			int crctAns = scanner.nextInt();

			PreparedStatement pst = con.prepareStatement("insert into answer values(?,?,?,?,?,?)");
			pst.setString(1, quesNo);
			pst.setString(2, option1);
			pst.setString(3, option2);
			pst.setString(4, option3);
			pst.setString(5, option4);
			pst.setInt(6, crctAns);
			int bool = pst.executeUpdate();

			System.out.println("Added!! Move to next question...");

		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}

	}

	public void takeQuiz() {
		logger.info("In QuizDaoImp->takeQuiz");
		try {
			Connection con = DBUtil.getConnection();
			scanner.nextLine();
			System.out.print("Enter your quizId to take quiz:");
			String quizId = scanner.nextLine();
			int flag=0;
//			if (quizIdList.contains(quizId)) {
				scanner.nextLine();
				System.out.print("Enter your id:");
				int rollNo = scanner.nextInt();
				String studName = "", subName = "";
				//String sql = "select s.id,s.sname,sub.id,sub.name,quiz.id from student s join subject sub on  s.classNo=sub.classNo join quiz on sub.id=quiz.subId where s.id="+ rollNo;
				
				String sql ="select s.id,s.sname,sc.subId,sub.name,q.id as QuizId,q.name as QuizName from student s \r\n"
						+ "join subject_class sc on s.classNo=sc.classNo \r\n"
						+ "join subject sub on sc.subId=sub.id\r\n"
						+ "join quiz q on q.subId=sub.id where s.id="+rollNo;
				
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					studName = resultSet.getString(2);
					subName = resultSet.getString(4);
					flag=1;
				}
				
				// System.out.println(rollNo+" "+studName+" "+subId+" "+subName+" "+quizId);
				if(flag==1) {
				String query = "select q.quesNo,q.question,a.option1,a.option2,a.option3,a.option4,a.crctAns from question q join answer a on q.quesNo=a.quesNo";
				int score = 0;
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery(query);
				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " \n" + rs.getString(3) + " \n"
							+ rs.getString(4) + " \n" + rs.getString(5) + " \n" + rs.getString(6));
					System.out.print("Enter your answer:");
					int chooseAns = scanner.nextInt();
					if (chooseAns == rs.getInt(7)) {
						score = score + 1;
					}
				}
				System.out.println("Your score is " + score);

				String query1 = "insert into result values(?,?,?,?,?,?)";
				PreparedStatement pst1 = con.prepareStatement(query1);
				pst1.setInt(1, rollNo);
				pst1.setString(2, studName);
				pst1.setInt(3, subId);
				pst1.setString(4, subName);
				pst1.setString(5, quizId);
				pst1.setInt(6, score);
				pst1.executeUpdate();
			} else {
				throw new InvalidException("Give correct quizId or RollNo to take the quiz");
			}
		} catch (SQLException |InvalidException e) {
			logger.warn(e.getMessage());
		}
	}

	public void result() {
		logger.info("In QuizDaoImp->Result");
		System.out.println("Results of all students");
		try {
			Connection con = DBUtil.getConnection();
			System.out.println("Enter you quizID:");
			String Id = scanner.nextLine();
			

			
			PreparedStatement pst = con.prepareStatement("select * from result where quizId=?");
			pst.setString(1, Id);
			ResultSet resultSet=pst.executeQuery();
			
			
			System.out.println(
					"studId" + " " + "studName" + " " + "subId" + " " + "subName" + " " + "quizId" + " " + "Score\n");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " "
						+ resultSet.getString(4) + " " + resultSet.getString(5) + " " + resultSet.getInt(6));
			}

		} catch (SQLException e) {
			logger.warn(e.getMessage());
		}
	}
}