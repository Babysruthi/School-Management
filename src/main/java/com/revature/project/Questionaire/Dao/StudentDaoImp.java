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

public class StudentDaoImp implements StudentDao
{
	
	Scanner scanner=new Scanner(System.in);
//public void checkTeacher(String teacherId,String teacherPass)throws Exception
//	{
//	Connection con=DBUtil.getConnection();
//	Statement st = con.createStatement();
//	String query = ("select * from teacherlogin");
//	String id1=new String();
//	String pass1=new String();
//	ResultSet rs = st.executeQuery(query);
//	if(rs.next()) 
//	{ 
//	 id1= rs.getString("id"); 
//	 pass1 = rs.getString("pass");
//
//	}
//	if(teacherId.equals(id1)&&teacherPass.equals(pass1))
//	{
//		System.out.println("Welcome!! Have a Nice Day");
//	}
//	else
//	{
//		System.out.println("Enter valid id or pass!!");
//	}
//	}
public void addStudent(Student student) throws Exception {
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			pst.setInt(1, student.getRollNo());
			pst.setString(2, student.getName());
			pst.setString(3, student.getDob());
			pst.setString(4, student.getStandard());
			pst.setString(5, student.getAddress());
			pst.setInt(6, student.getClassNo());
			pst.execute();
			System.out.println("data inserted..");

	}

public void deleteStudent(Student student) throws Exception{
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("delete from student where id=?");
	pst.setInt(1, student.getRollNo());
	pst.execute();
	System.out.println("Student removed....");
	

}

public void retrieveStudent(Student student) throws Exception{
	Connection con=DBUtil.getConnection();
	System.out.println("List of students are ....");
	String query="select * from student";
	PreparedStatement pst=con.prepareStatement(query);
	ResultSet resultSet=pst.executeQuery(query);
	while(resultSet.next())
	{
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
	}
	
}

public void updateStudent(Student student) throws Exception
{
	Connection con=DBUtil.getConnection();
	System.out.println("\nEnter the attribute to update \n1 StudentName\n2 DOB\n3 Standard\n4 Address");
	int teacherChoice=scanner.nextInt();
	System.out.println("Enter the student's id to update");
	int id=scanner.nextInt();
	if(teacherChoice==1)
	{
		System.out.println("Enter new name to update");
		scanner.nextLine();
		String newName=scanner.nextLine();
		String query="update student set name=? where id=?";
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setString(1, newName);
		preparedStatement.setInt(2, id);
		int executeResult=preparedStatement.executeUpdate();
		if(executeResult>0)
			System.out.println("student's name is updated");
		else
			System.out.println("Invalid id!!");
	}
	if(teacherChoice==2)
	{
		System.out.println("Enter correct DOB to update");
		scanner.nextLine();
		String newDob=scanner.nextLine();
		String query="update student set dob=? where id=?";
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setString(1, newDob);
		preparedStatement.setInt(2, id);
		int executeResult=preparedStatement.executeUpdate();
		if(executeResult>0)
			System.out.println("DOB is updated");
		else
			System.out.println("Invalid user id!!");
	}
	if(teacherChoice==3)
	{
		System.out.println("Enter student's standard to update");
		scanner.nextLine();
		String newStandard=scanner.nextLine();
		String query="update student set standard=? where id=?";
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setString(1,newStandard );
		preparedStatement.setInt(2, id);
		int executeResult=preparedStatement.executeUpdate();
		if(executeResult>0)
			System.out.println("Standard is updated");
		else
			System.out.println("Invalid user id!!");
	}
	if(teacherChoice==4)
	{
		System.out.println("Enter new address to update");
		scanner.nextLine();
		String newAddress=scanner.nextLine();
		String query="update student set address=? where id=?";
		PreparedStatement preparedStatement=con.prepareStatement(query);
		preparedStatement.setString(1,newAddress);
		preparedStatement.setInt(2, id);
		int executeResult=preparedStatement.executeUpdate();
		if(executeResult>0)
			System.out.println("Address is updated");
		else
			System.out.println("Invalid user id!!");
	}
	
}


public void addSubject(Subject subject) throws Exception {
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("insert into subject values(?,?,?,?)");
	pst.setInt(1, subject.getSubId());
	pst.setString(2,subject.getSubName());
	pst.setInt(3,subject.getStudId());
	pst.setInt(4, subject.getClassNo());
	pst.execute();
	System.out.println("Subject added....");

}

public void removeSubject(Subject subject) throws Exception
{
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("delete from subject where id=?");
	pst.setInt(1, subject.getSubId());
	pst.execute();
	System.out.println("subject removed....");
}

public void listSubject() throws Exception
{
	//Subject subject=new Subject();
	Connection con=DBUtil.getConnection();
	int classNo=scanner.nextInt();
	String query="select name from subject where classNo="+classNo;
	PreparedStatement pst=con.prepareStatement(query);
	ResultSet resultSet=pst.executeQuery(query);
	while(resultSet.next())
	{
		System.out.println(resultSet.getString(1));
	}
}

public void updateSubject() throws Exception
{
	Subject subject=new Subject();
	Connection con=DBUtil.getConnection();
}





public void addQuiz() throws Exception
{
	Quiz quiz=new Quiz();
	Connection con=DBUtil.getConnection();
	System.out.println("Enter subId");
	int subId=scanner.nextInt();
	System.out.println("Enter quizId");
	int quizId=scanner.nextInt();
	System.out.println("Enter totalQues");
	int totalQues=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter quizname");
	String quizName=scanner.nextLine();
	
	PreparedStatement pst=con.prepareStatement("insert into quiz values(?,?,?,?)");
	pst.setInt(1,subId);
	pst.setInt(2,quizId);
	pst.setString(3,quizName);
	pst.setInt(4, totalQues);
	pst.execute();
	System.out.println("You are ready to add questions!!!....");
}


public void addQuestion() throws Exception
{
	Question question=new Question();
	Connection con=DBUtil.getConnection();
	System.out.println("Enter quizId");
	int quizId=scanner.nextInt();
	System.out.println("Enter quesNo");
	int quesNo=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter question");
	String ques=scanner.nextLine();
	
	
	PreparedStatement pst=con.prepareStatement("insert into question values(?,?,?)");
	pst.setInt(1,quizId);
	pst.setInt(2,quesNo);
	pst.setString(3, ques);
	pst.execute();
	System.out.println("You are ready to add answers!!!....");
}

public void addAnswer() throws Exception
{
	Answer answer=new Answer();
	Connection con=DBUtil.getConnection();
	System.out.println("Enter quesNo");
	int quesNo=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter option1");
	String option1=scanner.nextLine();;
	System.out.println("Enter option2");
	String option2=scanner.nextLine();;
	System.out.println("Enter option3");
	String option3=scanner.nextLine();;
	System.out.println("Enter option4");
	String option4=scanner.nextLine();;
	System.out.println("Enter crct answer");
	int crctAns=scanner.nextInt();
	
	
	PreparedStatement pst=con.prepareStatement("insert into answer values(?,?,?,?,?,?)");
	pst.setInt(1,quesNo);
	pst.setString(2,option1);
	pst.setString(3,option2);
	pst.setString(4,option3);
	pst.setString(5,option4);
	pst.setInt(6,crctAns);
	pst.execute();
	System.out.println("Added!! Move to next question...");
}


public void result() throws Exception
{
	Connection con=DBUtil.getConnection();
	String query="select q.quesNo,q.question,a.option1,a.option2,a.option3,a.option4,a.crctAns from question q join answer a on q.quesNo=a.quesNo";
	int score=0;
	PreparedStatement preparedStatement=con.prepareStatement(query);
	ResultSet resultSet=preparedStatement.executeQuery(query);
	while(resultSet.next())
	{
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));
		System.out.println("Enter your response");
		int chooseAns=scanner.nextInt();
		if(chooseAns==resultSet.getInt(7))
		{
			score=score+1;
		}
	}
	
	System.out.println("Your score is:"+score);
}
}