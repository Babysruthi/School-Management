package com.revature.project.Questionaire.Service;

import com.revature.project.Questionaire.Student;
import com.revature.project.Questionaire.Subject;
import com.revature.project.exception.InvalidException;

public interface StudentService {
	public void addStudent(Student student) throws InvalidException, Exception;

	public void deleteStudent(Student student) throws InvalidException, Exception;

	public void retrieveStudent(Student student) throws InvalidException, Exception;

	public void updateStudent(Student student) throws InvalidException, Exception;

	public int checkTeacher(int teacherId, int teacherPass) throws InvalidException, Exception;

	public void addSubject(Subject subject) throws InvalidException, Exception;

	public void removeSubject(Subject subject) throws InvalidException, Exception;

	public void listSubject() throws InvalidException, Exception;

	public void updateSubject() throws InvalidException, Exception;

	public void addQuiz() throws InvalidException, Exception;

	public void deleteQuiz() throws InvalidException, Exception;

	public void listQuiz() throws InvalidException, Exception;

	public void addQuestion() throws InvalidException, Exception;

	public void addAnswer() throws InvalidException, Exception;

	public void takeQuiz() throws InvalidException, Exception;

	public void result() throws InvalidException, Exception;

}
