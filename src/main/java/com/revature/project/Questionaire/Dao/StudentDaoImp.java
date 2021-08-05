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

public class StudentDaoImp implements StudentDao
{
	int subId=0;
	Scanner scanner=new Scanner(System.in);
public int checkTeacher(int teacherId,int teacherPass)throws Exception
	{
	Connection con=DBUtil.getConnection();
	Statement st = con.createStatement();
	String query = ("select * from teacher");
	int id1=0,pass1=0;
	int flag=0;
	ResultSet rs = st.executeQuery(query);
	while(rs.next()) 
	{ 
	 id1= rs.getInt("id"); 
	 pass1 = rs.getInt("pass");
	 subId=rs.getInt("subId");

	 	if((teacherId==id1)&&(teacherPass==pass1))
	 	{
	 		flag=1;
	 	}
	 	
	}
	if(flag==1)
	{
		String sub="";
		ResultSet resultSet = st.executeQuery("select s.name from subject s join teacher t on s.id=t.subId where t.id="+teacherId);
		while(resultSet.next())
		{
			sub=resultSet.getString(1);
		}
		System.out.println(sub);
	}
	else
	{
		throw new InvalidException("Invalid user or pass!");
		
	}
	
	return subId;
	}
public void addStudent(Student student) throws Exception {
			Connection con=DBUtil.getConnection();
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?,?,?)");
			pst.setInt(1, student.getRollNo());
			pst.setString(2, student.getName());
			pst.setString(3, student.getDob());
			pst.setString(4, student.getStandard());
			pst.setString(5, student.getAddress());
			pst.setInt(6, student.getClassNo());
			int result=pst.executeUpdate();
			if(result>0)
			System.out.println("Student added..");
			else
				throw new InvalidException("Enter correct details!..Error..check datatypes,duplicates");

	}

public void deleteStudent(Student student) throws Exception{
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("delete from student where id=?");
	pst.setInt(1, student.getRollNo());
	int result=pst.executeUpdate();
	if(result>0)
	System.out.println("Student removed....");
	else

		throw new InvalidException("Student Id is not present");
	
	

}

public void retrieveStudent(Student student) throws Exception{
	Connection con=DBUtil.getConnection();
	System.out.println("List of students are ....");
	System.out.print("Enter classNo of students needed:");
	int classNo=scanner.nextInt();
	String query="select * from student where classNo="+classNo;
	PreparedStatement pst=con.prepareStatement(query);
	ResultSet resultSet=pst.executeQuery(query);
	System.out.println();
	if(resultSet.next()) {
	while(resultSet.next())
	{
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5));
	}}
	else
		throw new InvalidException("No list of students in this particular classNo "+classNo);
	
}

public void updateStudent(Student student) throws Exception
{
	Connection con=DBUtil.getConnection();
	System.out.println("\nEnter the attribute to update \n1 StudentName\n2 DOB\n3 Standard\n4 Address");
	int teacherChoice=scanner.nextInt();
	System.out.println("Enter the student's id to update:");
	int id=scanner.nextInt();
	if(teacherChoice==1)
	{
		System.out.println("Enter new name to update:");
		scanner.nextLine();
		String newName=scanner.nextLine();
		String query="update student set sname=? where id=?";
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
		System.out.println("Enter correct DOB to update:");
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
		System.out.println("Enter student's standard to update:");
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
		System.out.println("Enter new address to update:");
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
	PreparedStatement pst=con.prepareStatement("insert into subject values(?,?,?)");
	pst.setInt(1, subject.getSubId());
	pst.setString(2,subject.getSubName());
	pst.setInt(3, subject.getClassNo());
	int result=pst.executeUpdate();
	if(result>0)
	System.out.println("Subject added....");
	else
		throw new InvalidException("Enter correct details!..Error..check datatypes,duplicates");


}

public void removeSubject(Subject subject) throws Exception
{
	Connection con=DBUtil.getConnection();
	PreparedStatement pst=con.prepareStatement("delete from subject where id=?");
	pst.setInt(1, subject.getSubId());
	int result=pst.executeUpdate();
	if(result>0)
	System.out.println("subject removed....");
	else
		throw new InvalidException("Subject Id is not found");
}

public void listSubject() throws Exception
{
	//Subject subject=new Subject();
	Connection con=DBUtil.getConnection();
	System.out.print("Enter classNo whose subjects are needed:");
	int classNo=scanner.nextInt();
	String query="select name from subject where classNo="+classNo;
	PreparedStatement pst=con.prepareStatement(query);
	ResultSet resultSet=pst.executeQuery(query);
	if(resultSet.next()) {
	while(resultSet.next())
	{
		System.out.println(resultSet.getString(1));
	}}
	else
		System.out.println("No subjects alloted for the cls "+classNo+" yet");
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
	System.out.print("Enter subId:");
	int sId=scanner.nextInt();
	if(sId==subId)
	{
		System.out.print("Enter quizId:");
		String quizId=scanner.nextLine();
		scanner.nextLine();
		System.out.print("Enter totalQues:");
		int totalQues=scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter quizname:");
		String quizName=scanner.nextLine();
	
		PreparedStatement pst=con.prepareStatement("insert into quiz values(?,?,?,?)");
		pst.setInt(1,sId);
		pst.setString(2,quizId);
		pst.setString(3,quizName);
		pst.setInt(4, totalQues);
		int result=pst.executeUpdate();
		if(result>0)
			System.out.println("You are ready to add questions!!!....");
		else
			throw new InvalidException("Query is not executed!! Error...");
	}
	else
	{
		throw new InvalidException("You can't able to create quiz for subjectId "+sId);
	}
}
public void deleteQuiz() throws Exception
{
	
	Connection con=DBUtil.getConnection();
	System.out.print("Enter quizId to delete:");
	String quizId=scanner.nextLine();
	PreparedStatement pst=con.prepareStatement("delete from quiz where id=?");
	pst.setString(1,quizId );
	int result=pst.executeUpdate();
	if(result>0)
	System.out.println("quiz with "+quizId+" deleted");
	else
		throw new InvalidException("QuizId is not found");
}

public void listQuiz() throws Exception
{
	Quiz quiz=new Quiz();
	Connection con=DBUtil.getConnection();
	System.out.print("Enter subId to list quizzes");
	int sId=scanner.nextInt();
	if(sId==subId)
	{
		String query="select id,name from quiz where subId="+sId;
		PreparedStatement pst=con.prepareStatement(query);
		ResultSet resultSet=pst.executeQuery(query);
		if(resultSet.next()) {
		while(resultSet.next())
		{
			System.out.println(resultSet.getString(1));
		}}
		else
			System.out.println("No quizes created for this subjectId "+sId+" yet");
	}
	else
		throw new InvalidException("Enter your subjectId correctly..!");
}



public void addQuestion() throws Exception
{
	Question question=new Question();
	Connection con=DBUtil.getConnection();
	System.out.print("Enter quizId:");
	String quizId=scanner.nextLine();
	System.out.print("Enter quesNo:");
	String quesNo=scanner.nextLine();
	System.out.print("Enter question:");
	String ques=scanner.nextLine();
	
	
	PreparedStatement pst=con.prepareStatement("insert into question values(?,?,?)");
	pst.setString(1,quizId);
	pst.setString(2,quesNo);
	pst.setString(3, ques);
	int result=pst.executeUpdate();
	if(result>0)
		System.out.println("Questions are added successfully....");
	else
		throw new InvalidException("In addQuestion(),Query is not inserted, May be some duplicates..Error!");
}

public void addAnswer() throws Exception
{
	Answer answer=new Answer();
	Connection con=DBUtil.getConnection();
	scanner.nextLine();
	System.out.print("Enter quesNo:");
	String quesNo=scanner.nextLine();
	System.out.print("Enter option1:");
	String option1=scanner.nextLine();;
	System.out.print("Enter option2:");
	String option2=scanner.nextLine();;
	System.out.print("Enter option3:");
	String option3=scanner.nextLine();;
	System.out.print("Enter option4:");
	String option4=scanner.nextLine();;
	System.out.print("Enter crct answer:");
	int crctAns=scanner.nextInt();
	
	
	PreparedStatement pst=con.prepareStatement("insert into answer values(?,?,?,?,?,?)");
	pst.setString(1,quesNo);
	pst.setString(2,option1);
	pst.setString(3,option2);
	pst.setString(4,option3);
	pst.setString(5,option4);
	pst.setInt(6,crctAns);
	int bool=pst.executeUpdate();
	if(bool>0)
		System.out.println("Added!! Move to next question...");
	else
		throw new InvalidException("In addAnswers(),Query is not inserted, May be some duplicates..Error!");
}


public void takeQuiz() throws Exception
{
	Connection con=DBUtil.getConnection();
	System.out.print("Enter your quizId to take quiz:");
	String quizId=scanner.nextLine();
	scanner.nextLine();
	System.out.print("Enter your id:");
	int rollNo=scanner.nextInt();
	String query="select q.quesNo,q.question,a.option1,a.option2,a.option3,a.option4,a.crctAns from question q join answer a on q.quesNo=a.quesNo";
	int score=0;
	int subId=0;
	//String quizId="";
	String studName="",subName="";
	String sql="select s.id,s.sname,sub.id,sub.name,quiz.id from student s join subject sub on  s.classNo=sub.classNo join quiz on sub.id=quiz.subId where s.id="+rollNo;
	Statement statement=con.createStatement();
	ResultSet resultSet=statement.executeQuery(sql);
	while(resultSet.next())
	{
		//rollNo=resultSet.getInt(1);
		studName=resultSet.getString(2);
		subId=resultSet.getInt(3);
		subName=resultSet.getString(4);
		//quizId=resultSet.getString(5);
	}
	//System.out.println(rollNo+" "+studName+" "+subId+" "+subName+" "+quizId);
	PreparedStatement pst=con.prepareStatement(query);
	ResultSet rs=pst.executeQuery(query);
	while(rs.next())
	{
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" \n"+rs.getString(3)+" \n"+rs.getString(4)+" \n"+rs.getString(5)+" \n"+rs.getString(6));
		System.out.print("Enter your answer:");
		int chooseAns=scanner.nextInt();
		if(chooseAns==rs.getInt(7))
		{
			score=score+1;
		}
	}
	System.out.println("Your score is "+score);
	
	String query1="insert into result values(?,?,?,?,?,?)";
	PreparedStatement pst1=con.prepareStatement(query1);
	pst1.setInt(1,rollNo);
	pst1.setString(2,studName);
	pst1.setInt(3,subId);
	pst1.setString(4,subName);
	pst1.setString(5,quizId);
	pst1.setInt(6,score);
	pst1.execute();
	}	



public void result() throws Exception
{
	System.out.println("Results of all students");
	
	Connection con=DBUtil.getConnection();
	
	String query1="select * from result";
	PreparedStatement pst1=con.prepareStatement(query1);
	ResultSet resultSet=pst1.executeQuery(query1);
	//System.out.println("studId"+" "+"studName"+" "+"subId"+" "+"subName"+" "+"quizId"+" "+"Score\n");
	while(resultSet.next())
	{
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getInt(6));
	}
	}
}
