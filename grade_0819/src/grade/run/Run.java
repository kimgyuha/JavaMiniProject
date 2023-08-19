package grade.run;
import java.util.ArrayList;
import java.util.List;

import grade.student.*;
import grade.subject.*;

public class Run {

	public static void main(String[] args) {
		
		Student student1 = new Student("김지용", 19392, "국어");
		Student student2 = new Student("한우주", 12349, "수학");
		Student student3 = new Student("최민석", 20342, "국어");
		Student student4 = new Student("이민혁", 23324, "수학");
		Student student5 = new Student("박현태", 12398, "수학");
		
		DanceS dance = new DanceS();
		KoreanS korean = new KoreanS();
		MathS math = new MathS();
		
		dance.register(student1, 90);
		dance.register(student2, 80);
		dance.register(student3, 40);
		
		korean.register(student1, 95);
		korean.register(student2, 100);
		korean.register(student3, 30);
		korean.register(student4, 80);
		korean.register(student5, 50);
	
		math.register(student1, 98);
		math.register(student2, 100);
		math.register(student3, 20);
		math.register(student4, 70);
		math.register(student5, 10);
		
		List<Student> studentsK = korean.getStudents();
		List<Integer> scoresK = korean.getScores();
		List<String> gradesK = korean.getGrades();
		
		System.out.println("---------------------");
		System.out.println("   국어 수강생 학점   ");
		System.out.println("이름 | 학번 |중점|점수");
		System.out.println("-----------------------");
		for(int i=0; i<studentsK.size(); i++) {
		
			System.out.print(studentsK.get(i));
			System.out.print(scoresK.get(i));
			System.out.print(gradesK.get(i));
			System.out.println();
		}
		
		List<Student> studentsM = math.getStudents();
		List<Integer> scoresM = math.getScores();
		List<String> gradesM = math.getGrades();
		System.out.println("----------------------");
		System.out.println("   수학 수강생 학점   ");
		System.out.println("이름 | 학번 |중점|점수");
		System.out.println("-----------------------");
		
		for (int i=0; i<studentsM.size(); i++) {
			
			System.out.print(studentsM.get(i));
			System.out.print(scoresM.get(i));
			System.out.print(gradesM.get(i));
			System.out.println();
		}
		
		List<Student> studentsD = dance.getStudents();
		List<Integer> scoresD = dance.getScores();
		List<String> gradesD = dance.getGrades();
		
		System.out.println("----------------------");
		System.out.println(" 방송댄스 수강생 학점   ");
		System.out.println("이름 | 학번 |중점|점수");
		System.out.println("-----------------------");
		
		for (int i = 0; i < studentsD.size(); i++) {
			System.out.print(studentsD.get(i));
			System.out.print(scoresD.get(i));
			System.out.print(gradesD.get(i));
			System.out.println();
		}
		System.out.println("----------------------------");
	}

}
