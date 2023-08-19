package grade.subject;

import java.util.ArrayList;
import java.util.List;
import grade.evaluation.*;
import grade.student.Student;

public class DanceS {
	private String grade;
	private int score;
	private Student student;
	
	private List<String> grades = new ArrayList<String>();
	private List<Integer> scores = new ArrayList<Integer>();
	private List<Student> students = new ArrayList <Student>();

	public void register(Student student, int score) {
		this.student = student; 
		students.add(student);
		scoreOfStudent(score);
		gradeOfStudent(score);
	}
	
	public void scoreOfStudent(int score) {
		this.score = score;
		scores.add(score);
		
	}
	public void gradeOfStudent(int score) {
		PassFail pf = new PassFail();
		this.grade = pf.GradeOfSubject(score);
		grades.add(grade);
	}
	
	public List<String> getGrades() {
		return grades;
	}

	public void setGrades(List<String> grades) {
		this.grades = grades;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String toString() {
		return student + "|" + score + "|" + grade;
	}
	
}