package grade.evaluation;

public class PassFail implements GradeEvaluation {
	private String grade; 
	public String GradeOfSubject(int score) {
		if(score >= 60)
			grade = "P";
		else
			grade = "F";
		return grade;
	}
}
