package grade.subject;
import java.util.ArrayList;
import java.util.List;

import grade.evaluation.*;
import grade.student.Student;

public class KoreanS {
	private String grade;
	private int score;
	private Student student = null;
	private List<String> grades = new ArrayList<String>();
	private List<Integer> scores = new ArrayList<Integer>();
	private List<Student> students = new ArrayList <Student>();
	
	public void register(Student student, int score) {
		this.student = student; 
		students.add(student);
		scoreOfStudent(score);
		gradeOfStudent(student.getMajorSub(), score);
	}	
	public void scoreOfStudent(int score) {
		this.score = score;
		scores.add(score);	
	}
	public void gradeOfStudent(String majorSub, int score) {
		 if(majorSub != null && majorSub.equals("국어")) {
			//ajorSub != null 이 조건을 안넣어주면 코드에 문제가 없어도
			 //nullPointException 발생 (equals함수쓸때 자주 오류남)
			Major m = new Major();
			this.grade = m.GradeOfSubject(score);
			grades.add(grade);
		}else if(majorSub != null && majorSub.equals("수학")){ //필수과목이 국어가 아닌 수학인 학생
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
		return student + "|" + score;
	//grade는 아직 확정되지 않아서 여기서 출력정의를 할수없음
	}
}
