package grade.subject;

import java.util.ArrayList;
import java.util.List;

import grade.student.Student;
import grade.evaluation.*;

public class MathS {
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
		gradeOfStudent(student.getMajorSub(), score);
		//scoreOfStudent()함수가 아닌 여기 둬야 제대로 값이 나옴
		//scoreOfStudent()에 두면 index오류 남
	}
	public void scoreOfStudent(int score) {
		this.score = score;
		scores.add(score);
	}
	public void gradeOfStudent(String majorSub, int score) {
		if(majorSub != null && majorSub.equals("수학")) {
			Major m = new Major();
			this.grade = m.GradeOfSubject(score);
			grades.add(grade);
		}else if(majorSub != null && majorSub.equals("국어")){ //필수과목이 국어가 아닌 수학인 학생
			Basic b = new Basic();
			this.grade = b.GradeOfSubject(score);
			grades.add(grade);
		}
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