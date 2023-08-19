package school;

import java.util.ArrayList;
import java.util.List;
import grade.*;

public class Report {
	public static final String TITLE = " 수강생 학점 \t\t\n";
	public static final String HEADER = " 이름 | 과목 | 점수 \n";
	public static final String LINE = "-------------------------------\n";

	private StringBuffer buffer = new StringBuffer();
	Controller cl = new Controller();
	Define df = new Define();

//	public String getReport() {
//		List<Subject> subjectList = cl.getSubjectList();
//
//		for (Subject subject : subjectList) {
//			makeHeader(subject);
//			makeBody(subject);
//			makeFooter();
//		
//		}
//		return buffer.toString();
//	}
	public List<Subject> getReport() {
		List<Subject> subjectList = cl.getSubjectList();
			return subjectList;
		}
//	
//	public void makeHeader(Subject subject) {
//		buffer.append(Report.LINE);
//		buffer.append("\t" + subject.getSubjectName());
//		buffer.append(Report.TITLE);
//		buffer.append(Report.HEADER);
//		buffer.append(Report.LINE);
//	}
//
//	public void makeBody(Subject subject) {
//		List<Student> studentList = cl.getStudentList();
//
//		for (int i = 0; i < studentList.size(); i++) {
//			Student student = studentList.get(i);
//			buffer.append(student.getStudentName());
//			buffer.append("|");
//			buffer.append(student.getMajorSubject() + "\t");
//			buffer.append("|");
//
////			getScoreGrade(student);
//
//			buffer.append("\n");
//			buffer.append(LINE);
//		}
//	}

//	public void getScoreGrade(Student student) {
//		List<Score> scoreList = cl.getScoreList();
//		int majorId = student.getMajorSubject().getSubjectId();
//
//		GradeEvaluation[] gradeEvaluation = { new BasicEvaluation(), new MajorEvaluation() };
//
//		for (int i = 0; i < scoreList.size(); i++) {
//			Score score = scoreList.get(i);
//			Subject subject = new Subject();
//			if (score.getSubject().getSubjectId() == subject.getSubjectId()) {
//				String grade;
//				if (score.getSubject().getSubjectId() == majorId)
//					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getScore());
//				else
//					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getScore());
//
//				buffer.append(score.getScore());
//				buffer.append(":");
//				buffer.append(grade);
//				buffer.append(":");
//
//			}
//		}
//	}

	public void makeFooter() {
		buffer.append("\n");
	}
}
