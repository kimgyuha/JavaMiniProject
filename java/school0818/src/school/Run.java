package school;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import grade.*;

public class Run {
	School goodSchool = School.getInstance();
	List<Subject> subjectList = new ArrayList<Subject>();
	List<Student> studentList = new ArrayList <Student>();
	List<Score> scoreList = new ArrayList<Score>(); 
	Map<Subject, Map<String, Integer>> totalMap = new HashMap<>();

//	Map<String, Integer> stuscoMap;
//	List<Map<String, Integer>> stuscoList; 
	
	Subject korean;
	Subject math;
	Report gradeReport = new Report();
	Controller cl = new Controller();

	public static void main(String[] args) {
		//프로그램은 메인에서 시작해서 내려가면서 실행됨(클래스를 왔다갔다하더라도 메인으로 돌아옴)
		Run run = new Run();
		
		run.createSubject();
		//System.out.println("끄읏 나면 안돼");
		List<Subject> report = run.gradeReport.getReport();
		System.out.println(report);
		System.out.println("엥?ㅋ");
		
	}
	public void createSubject() {
		korean = new Subject("국어", Define.KOREAN);
		math = new Subject("수학", Define.MATH);
		cl.mainList();
	}
	public void add() {
		totalMap = cl.addSubject();
		goodSchool.addStudent(totalMap);
	
	}
	
}
